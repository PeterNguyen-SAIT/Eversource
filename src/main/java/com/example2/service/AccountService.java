package com.example2.service;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public String resetPassword(String url)
    {
        String uuid = UUID.randomUUID().toString();
        String link = url + "&uuid=" + uuid;
        return link;
    }
    public String getLink(String url)
    {
        String uuid = UUID.randomUUID().toString();
        String link = url + "&uuid=" + uuid;
        return link;
    }
}
