package br.com.posto.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.posto.modelo.Tabela;
import br.com.posto.repository.TabelaRepository;

@Service
public class TabelaService {
	
	@Autowired
	private TabelaRepository tabelaRepository;
	
	public void importarCsv () throws IOException, ParseException {
		BufferedReader myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("PATH DO ARQUIVO CSV"), "CP1252"));
		String linha = myBuffer.readLine();
		String csv = "";
		while (linha != null) {
			String linha_ = linha.replace("\"", "");
			csv += linha_ + "\n";
			linha = myBuffer.readLine();
		}
		myBuffer.close();
		String[] lines = csv.split("\\n");
		for (String line : lines) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Tabela tabela = new Tabela();
			Date dataColeta = new Date();
			String[] cols = line.split(";");
			tabela.setRegiao(cols[0]);
			tabela.setEstadoSigla(cols[1]);
			tabela.setMunicipio(cols[2]);
			tabela.setRevenda(cols[3]);
			tabela.setCnpj(cols[4]);
			tabela.setProduto(cols[5]);
			String dataString = cols[6];
			dataColeta = format.parse(dataString);
			tabela.setDataColeta(dataColeta);
			if (!cols[7].isEmpty()) {
				String valorVenda = cols[7].replace(",", ".");
				tabela.setValorVenda(Double.parseDouble(valorVenda));
			}
			if (!cols[8].isEmpty()) {
				String valorCompra = cols[8].replace(",", ".");
				tabela.setValorCompra(Double.parseDouble(valorCompra));
			}
			tabela.setUnidadeMedida(cols[9]);
			tabela.setBandeira(cols[10]);
			tabelaRepository.save(tabela);
		}
	}

}
