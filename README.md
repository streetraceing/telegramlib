# TelegramLib

TelegramLib - это библиотека, реализованная по основам Telegram Bot API. В проекте использованы возможности Java 8 версии. Кратко можно сказать, что в ней присутствует большинство взаимодействий с телеграм ботами. Это небольшой проект быстрой, удобной и гибкой библиотеки с целью создания и масштабирования ботов Telegram.

## Использование
> [!NOTE]\
> Загрузка с помощью Maven и Gradle не реализована.

[TelegramLib jar](https://github.com/streetraceing/telegramlib/releases) файлы можно скачать с релизов на Github.

## Требования
Минимальная версия Java:
- TelegramLib 1.3.0: `Java 8`

Дополнительные зависимости:
- [Gson 2.12.1](https://github.com/google/gson/releases/tag/gson-parent-2.12.1)

## Документация

### Приступаем к работе
Начать работу с библиотекой можно через создание экземпляра бота, это требует токен бота.<br>
[Как получить токен?](https://core.telegram.org/bots/tutorial#getting-ready)
```java
import net.strdev.telegramlib.api.Bot;

public class Example {
    public static void main(String[] args) {
        String token = args[0];
        Bot bot = new Bot(token);
    }
}
```
Класс бота при инициализации включает Polling (постоянную отправку запросов `/getUpdates`), для дальнейшей работы необходимо создавать ивенты.

### Регистрация ивентов
Чтобы зарегистрировать любой ивент используются методы, начинающиеся на `on` в экземпляре бота. <br>
Доступные ивенты на данный момент: `onText`, `onCommand`, `onEdit`, `onPhoto`, `onSticker`, `onAudio`, `onVideo`, `onPoll`, `onLocation`, `onDocument`, `onContact`, `onStory`, `onVoice`, `onAnimation`, `onDice`, `onCallbackQuery`.

Сами ивенты в методе регистрации требуют передачи функционального интерфейса `Consumer`, который в реализации передаёт данные об ивенте.

Для примера можно написать такой код. Теперь при любом текстовом сообщении бот ответит на него "Hello world!".
```java
import net.strdev.telegramlib.api.Bot;

public class Example {
    public static void main(String[] args) {
        String token = args[0];
        Bot bot = new Bot(token);

        bot.onText(msg -> msg.reply("Hello World!"));
    }
}
```
Обработка команд (текстовых сообщений, начинающихся с определенной команды, например `/start`) выглядит следующим образом.
```java
import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.commands.CommandHandler;

public class Example {
    public static void main(String[] args) {
        String token = args[0];
        Bot bot = new Bot(token);

        bot.onCommand(new CommandHandler("/start", response -> {
            String arg1 = response.args[0];
            System.out.println("Вы написали: " + arg1);
        }));
    }
}
```
### Встроенные функции
В экземпляре класса бота доступны базовые методы, такие как `sendText`, `addReaction`, `replyMessageText`, `deleteMessage`, `editTextMessage`.

Также в `CommandResponse` и `MessageScheme` возвращаются методы взаимодействия с сообщением: `send`, `reply`, `react`.

### Работа с клавиатурами
Допустим, спросим пользователя о его состоянии. После команды `/start` отправится сообщение "Как дела?", имеющее Inline-клавиатуру с выбором.
```java
import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.commands.CommandHandler;
import net.strdev.telegramlib.requests.sendMessage;
import net.strdev.telegramlib.types.serializable.InlineKeyboardButton;
import net.strdev.telegramlib.types.serializable.InlineKeyboardMarkup;

public class Example {
    public static void main(String[] args) {
        String token = args[0];
        Bot bot = new Bot(token);

        bot.onCommand(new CommandHandler("start", response -> {
            bot.sendRequest(
                    new sendMessage().chat_id(response.chat.id).text("Как дела?")
                    .reply_markup(new InlineKeyboardMarkup(
                    new InlineKeyboardButton[][]{{
                        new InlineKeyboardButton().text("Всё отлично!"),
                        new InlineKeyboardButton().text("Не очень.")
                    }}))
            );
        }));
    }
}
```

Или отправим встроенную в приложение одноразовую клавиатуру.
```java
import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.commands.CommandHandler;
import net.strdev.telegramlib.requests.sendMessage;
import net.strdev.telegramlib.types.serializable.KeyboardButton;
import net.strdev.telegramlib.types.serializable.ReplyKeyboardMarkup;

public class Example {
    public static void main(String[] args) {
        String token = args[0];
        Bot bot = new Bot(token);

        bot.onCommand(new CommandHandler("start", response -> {
            bot.sendRequest(
                new sendMessage().chat_id(response.chat.id).text("Как дела?")
                .reply_markup(new ReplyKeyboardMarkup().one_time_keyboard(true).keyboard(
                    new KeyboardButton[][]
                        {
                            { new KeyboardButton().text("Всё хорошо!") },
                            { new KeyboardButton().text("Не очень.") }
                        }
                ))
            );
        }));
    }
}
```
Встроенные клавиатуры могут быть удалены у пользователя:
```java
import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.commands.CommandHandler;
import net.strdev.telegramlib.requests.sendMessage;
import net.strdev.telegramlib.types.serializable.ReplyKeyboardRemove;

public class Example {
    public static void main(String[] args) {
        String token = args[0];
        Bot bot = new Bot(token);

        bot.onCommand(new CommandHandler("remove_keyboard", response -> {
            bot.sendRequest(
                new sendMessage().chat_id(response.chat.id).text("Удаляем клавиатуру...")
                .reply_markup(new ReplyKeyboardRemove())
            );
        }));
    }
}

```

### Нестандартные функции
Под этим понятием подразумевается использование `bot.sendRequest(TelegramRequest ...)`. В библиотеке используется гибкое построение https запросов. Использование таковых выглядит так.

Самое простое, что только может быть - отправка сообщения пользователю иным способом, отличным от `bot.sendText(String text, long chat_id)`. В запросе sendMessage, к примеру, может быть применено свойство `protect_content(true)`, что запретит его пересылать. <br>

`net.strdev.telegramlib.requests.*;` хранит все запросы, что доступны библиотеке (в будущем будут реализованы все запросы Telegram API).
```java
import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.requests.sendMessage;

public class Example {
    public static void main(String[] args) {
        String token = args[0];
        Bot bot = new Bot(token);

        long target_user_id = 0;
        String text = "Message";

        bot.sendRequest(new sendMessage().chat_id(target_user_id).text(text));
    }
}
```
### Создание своих запросов
Для того, чтобы сделать свой запрос к Telegram API от имени бота необходимо создать новый класс, наследованный от `TelegramRequest`. Подробнее про все доступные методы можно прочитать [по ссылке.](https://core.telegram.org/bots/api#available-methods)

Например, создадим урезанный запрос `sendPhoto`, имеющий в параметрах только `chat_id` и `photo`.
```java
import net.strdev.telegramlib.network.TelegramRequest;

public class sendPhoto extends TelegramRequest {
    // Инициализация класса вне класса бота
    // Используется в net.strdev.telegramlib.network.Requests.java
    public sendPhoto(String token) {
        // Токен и название метода, соответстующее доступным методам Telegram API
        super(token, "sendPhoto");
    }

    // Инициализация класса, в которую передаются данные от существующего бота
    // Используется в методе sendRequest net.strdev.telegramlib.api.Bot.java
    public sendPhoto() {
        super("sendPhoto");
    }

    // Сеттер параметра chat_id, принимающий ID чата
    // Использование long связано с особенностями API
    // Метод возвращает экземпляр этого же класса для удобного синтаксиса
    public sendPhoto chat_id(long value) {
        addQuery("chat_id", value);
        return this;
    }

    // Сеттер параметра photo, принимающий ID файла или ссылку на него
    public sendPhoto photo(String value) {
        addQuery("photo", value);
        return this;
    }

    // Сеттер параметра photo, принимающий InputFile (нереализованный класс в библиотеке,
    // в данном случае это используется для примера,
    // Похожие классы можно создать, наследовавшись от JsonObject или JsonArray 
    public sendPhoto photo(InputFile value) {
        // value.isMap() в случае с JsonObject
        // Необходимо передать в функцию данные именно как прямую
        // HashMap или ArrayList, чтобы в дальнейшем Gson мог работать корректно
        addQuery("photo", value.asMap());
        return this;
    }
}
```

### Создание своих сериализуемых типов данных
Понятие подразумевается как настраиваемый объект, наследованный от JsonObject или JsonArray, с возможностью использоваться для сериализации в Json формате. Структура похожа на `TelegramRequest`.

В пример будет взят существующий класс `ReplyParameters.java`.

```java
import net.strdev.telegramlib.types.serializable.base.JsonObject;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReplyParameters extends JsonObject {
    // Инициализация класса требует в себе обязательно message_id,
    // остальные параметры в Telegram API имеют опциональное значение.
    public ReplyParameters(Integer message_id) {
        add("message_id", message_id);
    }

    public ReplyParameters chat_id(int value) {
        add("chat_id", value);
        return this;
    }

    public ReplyParameters chat_id(String value) {
        add("chat_id", value);
        return this;
    }

    // ... 

    public ReplyParameters quote_entities(MessageEntity[] value) {
        // В Telegram API такой входящий параметр подразумевается
        // как Array of MessageEntity. Прохождение по всем элементам массива с lambda
        // выражением необходимо для избежания ошибок сериализации.
        add("quote_entities",
                Arrays.stream(value).map(MessageEntity::asMap).collect(Collectors.toList())
        );
        return this;
    }
}
```
### Отслеживание ошибок Telegram API
При работе с методом `sendRequest` в экземпляре класса бота или в `Requests.java` можно встретить TelegramException, которая оборачивается в `try/catch`. [Ошибки, с которыми можно встретиться.](https://core.telegram.org/file/400780400470/3/OY6JMkb69K4.143326.json/3c10f72ff9ce45e8a9)

Напишем простую команду, которая позволяет пользователю поставить реакцию на своё сообщение.
```java
import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.commands.CommandHandler;
import net.strdev.telegramlib.network.TelegramException;

public class Example {
    public static void main(String[] args) {
        String token = args[0];
        Bot bot = new Bot(token);

        bot.onCommand(new CommandHandler("react", response -> {
            String emoji = response.args[0];

            try {
                response.react(emoji);
            } catch (TelegramException exception) {
                response.reply("Вы ввели некорректный эмодзи!");
            }
        }));
    }
}
```

## Цели проекта
На данный момент установлен небольшой список целей, которые необходимо выполнить как можно быстрее. В будущем этот раздел будет изменяться.

- Портировать [все доступные методы](https://core.telegram.org/bots/api#available-methods) в `net.strdev.telegramlib.requests`, а так же необходимые для их использования сериализируемые классы.
- Создать репозиторий для загрузки библиотеки.
- Добавить документацию с типами данных при запросах.