package br.com.indicequeimadas.banco;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.indicequeimadas.controles.Pilha;
import br.com.indicequeimadas.inicio.Principal;
import br.com.indicequeimadas.telas.Visualizar;

public class AlimentarBanco {
	
	/**
	* @param stgs ArrayList<String[]> - QUE SERA PERCORRIDA PARA ATUALIZAR O BANCO DE DADOS.
	*/
	
	public void alimentarCSV(ArrayList<String[]> stgs) { DB.connect("BancoAps.db");
	ResultSet set = DB.query("SELECT * FROM IndiceQueimada");
	//System.out.println(res);
	new Thread() {// CRIANDO THREAD PARA NAO TRAVAR O PROGRAMA.
		@Override

		public void run() {

		Pilha p = new Pilha(stgs.size());// USANDO PILHA.

		int iIdata = 0;

		// DESATIVANDO OS BOTOES.

		Principal.getVisualizar().btnCarregar.setEnabled(false);


		Principal.getVisualizar().btnAtualizar.setEnabled(false);


		Principal.getVisualizar().btnExportarCSV.setEnabled(false); for (String[] data : stgs) {
		if (iIdata != 0) {

		for (int i = 0; i < data.length;
		i++) {

		data[i].replaceAll("'",
		"''");



		if (i == 0) {

		p.push("UPDATE IndiceQueimada SET DataHora = '" + data[i + 1] + "' ,Pais = '"+ data[i + 2] + "' ,Estado = '" + data[i + 3].replaceAll("'", "''")	+	"',Municipio = '" + data[i + 4] + "' ,Bioma = '" + data[i + 5]
		+	"',Latitude = " + data[i + 6] + " ,Longitude = " + data[i + 7]+",Satelite = '" + data[i + 8] + "' WHERE ID = " + iIdata);// ALIMENTANDO
		// PILHA COM
		// COMADOS QUE
		// SERA
		// UTILIZADOS.
		}
		}
		}
		iIdata++;
		}
		while (!p.isEmpty()) DB.execQuery(p.pop());// ENTRANDO EM LOOPING ENQUANTO EXECUTA OS COMANDOS PUXADOS DA PILHA
		// ATIVANDO OS BOTOES
		Principal.getVisualizar().btnCarregar.setEnabled(true);
		Principal.getVisualizar().btnAtualizar.setEnabled(true);
		Principal.getVisualizar().btnExportarCSV.setEnabled(true);
		}
	}.start();// INICIANDO A THREAD.
	}
}
