package com.felipe.eshop.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class ArquivoService {
    @Autowired
    private ClientePFService clientePFService;

    public String guardaNoArquivo(String nome) throws IOException {
        try {
            String arquivo = String.format("C:/Users/felipe.melo/Desktop/eshop/%s.txt",nome);
            FileWriter writer = new FileWriter(arquivo);
            String conteudo = clientePFService.converterParaString();
            writer.write(conteudo);
            writer.close();
            return "Arquivo gravado com sucesso";
        } catch (IOException e){
            return "Erro ao gravar o arquivo";
        }

    }
}
