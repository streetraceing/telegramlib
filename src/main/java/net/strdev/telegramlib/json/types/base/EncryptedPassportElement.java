package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class EncryptedPassportElement {
    public String type;
    public String data;
    public String phone_number;
    public String email;
    public List<PassportFile> files;
    public PassportFile front_side;
    public PassportFile reverse_side;
    public PassportFile selfie;
    public List<PassportFile> translation;
    public String hash;
}
