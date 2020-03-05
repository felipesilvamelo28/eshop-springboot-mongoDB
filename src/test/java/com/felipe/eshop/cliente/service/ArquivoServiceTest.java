package com.felipe.eshop.cliente.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ArquivoServiceTest {

    BufferedReader br = new BufferedReader(new FileReader("C:/Users/felipe.melo/Desktop/eshop/rais_exemplo.txt"));
    String linha = br.readLine();
    String[] dados = linha.split("\\|");

    public ArquivoServiceTest() throws IOException {
    }


    @Test
    public void PadraoStringArquivoRaisTipoRegistro1() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:/Users/felipe.melo/Desktop/eshop/export.txt"));
        String linha = br.readLine();
        String[] dados = linha.split("\\|");

        String nome = dados[0];
        String email = dados[1];
        String cpf = dados[2];

        assertThat(cpf.length()).isEqualTo(11);
        assertThat(cpf).isNotBlank();
        assertThat(email).contains("@");
        assertThat(email).contains(".com");
        assertThat(email).isNotBlank();


    }

    @Test
    public void seqRegistroArquivoTest(){
        //POSIÇÃO 001 A 006:

        String seqRegistroArquivo = linha.substring(0, 6);
        String seqRegistroArquivoIndice = String.valueOf(seqRegistroArquivo.charAt(5));
        System.out.println(seqRegistroArquivo);
        assertThat(seqRegistroArquivo).hasSize(6).startsWith("00000");
        assertThat(Integer.parseInt(seqRegistroArquivoIndice)).isGreaterThanOrEqualTo(1);

    }

    @Test
    public void cnpjEmpresaTest(){
        //POSIÇÃO 007 A 020:

        String cnpjEmpresa = linha.substring(7, 21);
        System.out.println(cnpjEmpresa);
        assertThat(cnpjEmpresa.length()).isEqualTo(14);
    }

    @Test
    public void prefixo1oEstabelecimentodoArquivoTest(){
        //POSIÇÃO 021 A 022:

        String prefixo1oEstabelecimentodoArquivo = linha.substring(21, 23);
        System.out.println(prefixo1oEstabelecimentodoArquivo);
        assertThat(prefixo1oEstabelecimentodoArquivo.length()).isEqualTo(2);
        assertThat(prefixo1oEstabelecimentodoArquivo).isEqualTo("00");
    }

    @Test
    public void tipoDoRegistroZeroTest(){
        //POSIÇÃO 023 A 023:

        String tipoDoRegistroZero = linha.substring(23, 24);
        System.out.println(tipoDoRegistroZero);
        assertThat(tipoDoRegistroZero.length()).isEqualTo(1);
        assertThat(tipoDoRegistroZero).isEqualTo("1");
    }

    @Test
    public void constanteTest(){
        //POSIÇÃO 024 A 024:

        String constante = linha.substring(24, 25);
        System.out.println(constante);
        assertThat(constante.length()).isEqualTo(1);
        assertThat(constante).isEqualTo("1");
    }

    @Test
    public void cnpjRespTest(){
        //POSIÇÃO 025 A 038:

        String cnpjResp = linha.substring(25, 39);
        System.out.println(cnpjResp);
        assertThat(cnpjResp.length()).isEqualTo(14);
    }

    @Test
    public void tipoInscricaoResponsavelTest(){
        //POSIÇÃO  039 A 039:

        String tipoInscricaoResponsavel = linha.substring(39, 40);
        assertThat(tipoInscricaoResponsavel.length()).isEqualTo(1);
        assertThat(tipoInscricaoResponsavel).isEqualTo("1");
    }

    @Test
    public void razaoSocialResponsavelTest(){
        //POSIÇÃO 040 A 079:

        String razaoSocialResponsavel = linha.substring(40, 80);
        System.out.println(razaoSocialResponsavel);
        assertThat(razaoSocialResponsavel.length()).isEqualTo(40);
    }

    @Test
    public void logradouroResponsavelTest(){
        //POSIÇÃO 80 A 119

        String logradouroResponsavel = linha.substring(80, 120);
        System.out.println(logradouroResponsavel);
        assertThat(logradouroResponsavel.length()).isEqualTo(40);
    }

    @Test
    public void numeroLogradouroResponsavelTest(){
        //POSIÇÃO 120 A 125:

        String numeroLogradouroResponsavel = linha.substring(120, 126);
        System.out.println(numeroLogradouroResponsavel);
        assertThat(numeroLogradouroResponsavel.length()).isEqualTo(6);
    }

    @Test
    public void complementoTest(){
        //POSIÇÃO 126 A 146:

        String complemento = linha.substring(126, 147);
        System.out.println(complemento);
        assertThat(complemento.length()).isEqualTo(21);
    }

    @Test
    public void bairroTest(){
        //POSIÇÃO 147 A 165:

        String bairro = linha.substring(147, 166);
        System.out.println(bairro);
        assertThat(bairro.length()).isEqualTo(19);
    }

    @Test
    public void cepTest(){
        //POSICAO 166 A 173:

        String cep = linha.substring(166, 174);
        System.out.println(cep);
        assertThat(cep.length()).isEqualTo(8);
    }

    @Test
    public void codigoMunicipioTest(){
        //POSIÇÃO 174 180:

        String codigoMunicipio = linha.substring(174, 181);
        System.out.println(codigoMunicipio);
        assertThat(codigoMunicipio.length()).isEqualTo(7);
    }

    @Test
    public void nomeMunicipioTest(){
        //POSIÇÃO 181 A 210:

        String nomeMunicipio = linha.substring(181, 211);
        System.out.println(nomeMunicipio);
        assertThat(nomeMunicipio.length()).isEqualTo(30);
    }

    @Test
    public void siglaUFTest(){
        //POSIÇÃO 211 A 212:

        String siglaUf = linha.substring(211, 213);
        System.out.println(siglaUf);
        assertThat(siglaUf.length()).isEqualTo(2);
    }

    @Test
    public void codigoDDDTest(){
        //POSIÇÃO 213 A 214:

        String codigoDDD = linha.substring(213, 215);
        System.out.println(codigoDDD);
        assertThat(codigoDDD.length()).isEqualTo(2);
    }

    @Test
    public void telefoneContatoTest(){
        //POSIÇÃO 215 A 224:

        String telefoneContato = linha.substring(215, 224);
        System.out.println(telefoneContato);
        assertThat(telefoneContato.length()).isEqualTo(9);
    }

    @Test
    public void indicadorRetificacaoTest(){
        //POSIÇÃO 224 A 224:

        String indicadorRetificacao = linha.substring(224, 225);
        int indicadorRetificacaoInt = Integer.parseInt(indicadorRetificacao);
        System.out.println(indicadorRetificacao);
        assertThat(indicadorRetificacao.length()).isEqualTo(1);
        assertThat(indicadorRetificacaoInt).isBetween(1, 2);
    }

    @Test
    public void dataRetificacaoEstabelecimentoTest(){
        //POSIÇÃO 225 A 232:

        String dataRetificacaoEstabelecimento = linha.substring(225, 233);
        System.out.println(dataRetificacaoEstabelecimento);
        assertThat(dataRetificacaoEstabelecimento.length()).isEqualTo(8);
    }

    @Test
    public void dataGeracaoArquivoTest(){
        //POSIÇÃO 233 240:

        String dataGeracaoArquivo = linha.substring(233, 241);
        System.out.println(dataGeracaoArquivo);
        assertThat(dataGeracaoArquivo.length()).isEqualTo(8);
    }

    @Test
    public void emailResponsavelTest(){
        //POSIÇÃO 241 A 285:

        String emailResponsavel = linha.substring(241, 286);
        System.out.println(emailResponsavel);
        assertThat(emailResponsavel.length()).isEqualTo(45);
    }

    @Test
    public void nomeResponsavelTest(){
        //POSIÇÃO 286 A 337:

        String nomeResponsavel = linha.substring(286, 338);
        System.out.println(nomeResponsavel);
        assertThat(nomeResponsavel.length()).isEqualTo(52);
    }

    @Test
    public void espacosTest(){
        //POSIÇÃO 338 A 361:

        String espacos = linha.substring(338, 362);
        System.out.println(espacos);
        assertThat(espacos.length()).isEqualTo(24);
    }

    @Test
    public void numeroCpfResponsavelTest(){
        //POSIÇÃO 362 A 372:

        String numeroCpfResponsavel = linha.substring(362, 373);
        System.out.println(numeroCpfResponsavel);
        assertThat(numeroCpfResponsavel.length()).isEqualTo(11);
    }

    @Test
    public void numeroCreaARetificarTest(){
        //POSIÇÃO 373 A 384:

        String numeroCreaARetificar = linha.substring(373, 385);
        System.out.println(numeroCreaARetificar);
        assertThat(numeroCreaARetificar.length()).isEqualTo(12);
    }

    @Test
    public void dataNascResponsavelTest(){
        //posição 385 a 392:

        String dataNascResponsavel = linha.substring(385, 393);
        System.out.println(dataNascResponsavel);
        assertThat(dataNascResponsavel.length()).isEqualTo(8);
    }

}
