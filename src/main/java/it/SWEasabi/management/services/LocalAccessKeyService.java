package it.SWEasabi.management.services;

public class LocalAccessKeyService implements AccessKeyService
{
    public String getAccessKey()
    {
        return "chiavePubblica";
    }
}