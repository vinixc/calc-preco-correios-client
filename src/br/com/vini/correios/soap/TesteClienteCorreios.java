package br.com.vini.correios.soap;

import java.math.BigDecimal;
import java.util.List;

public class TesteClienteCorreios {
	
	public static void main(String[] args) {
        CalcPrecoPrazoWSSoap cliente = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();
        
        
        String codigoSedex = "40010";
        String cepOrigem = "09896070";
        String cepDestino = "09921100"; 
        String peso3kg = "3";
        BigDecimal comprimento20cm = new BigDecimal(20);
        BigDecimal altura10cm = new BigDecimal(10);
        BigDecimal largura15cm = new BigDecimal(15);
        BigDecimal diametro10cm = new BigDecimal(10);
        int formatoEncomendaCaixa = 1; // 1 é caixa ou pacote
        BigDecimal semValorDeclarado= BigDecimal.ZERO;
        String semEntregueEmMaos = "N";
        String semAvisoRecebimento = "N";
        String semCodigoEmpresa = "";
        String semSenhaEmpresa = "";
        
      //fazendo a chamada do serviço
        CResultado resultado = cliente.calcPrecoPrazo(
                        semCodigoEmpresa, semSenhaEmpresa, 
                        codigoSedex, cepOrigem, cepDestino, 
                        peso3kg, formatoEncomendaCaixa, 
                        comprimento20cm, altura10cm, largura15cm, diametro10cm, 
                        semEntregueEmMaos, semValorDeclarado, semAvisoRecebimento);
        
        List<CServico> servicosPesquisados = resultado.getServicos().getCServico();
        String valorFrete = servicosPesquisados.get(0).getValor();

        System.out.printf("Frete para %s eh de %s %n", cepDestino, valorFrete);
        
    }
}
