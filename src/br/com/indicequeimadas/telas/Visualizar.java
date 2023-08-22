package br.com.indicequeimadas.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import br.com.indicequeimadas.banco.DB;
import br.com.indicequeimadas.controles.Fila;

public class Visualizar extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * PAINEL QUE ESTOU UTLIZANDO COMO BASE PARA ALINHAR TUDO MAIS FACILMENTE
	 */

	private JPanel ctnPainelVisualizar;

	/**
	 * 
	 * SCROLL PANE PARA PODER PERCORRER TUDO QUE POSSUI NA TABELA DE FORMA MAIS
	 * COMPACTA
	 * 
	 */

	private JScrollPane scrollPane;

	/**
	 * 
	 * CLASSE VIZUALIZAR INSTANCIADA
	 * 
	 */

	private Visualizar self;

	/**
	 * 
	 * TABELA
	 * 
	 */

	private JTable table1;

	/**
	 * 
	 * MODELO DA TABELA
	 * 
	 */

	DefaultTableModel modelo;

	/**
	 * LOCAL QUE ESTA .CSV
	 * 
	 */

	String localCSV = "";

	/**
	 * 
	 * BOTAO PARA CARREGAR A PARTIR DO BANCO DE DADOS OU .CSV(QUE IRA ATUALIZAR
	 * BANCO DE DADOS A PARTIR DELE)
	 * 
	 */

	public JButton btnCarregar;

	/**
	 * 
	 * BOTAO PARA ATUALIZAR O BANCO DE DADOS A PARTIR DA TABELA
	 * 
	 */

	public JButton btnAtualizar;

	/**
	 * 
	 * BOTAO PARA EXPORTAR CSV E CASO NAO TENHA SELECIONADO .CSV IRA PEDIR PARA
	 * SELECIONAR
	 * 
	 */

	public JButton btnExportarCSV;

	/**
	 * 
	 * BANCO QUE IRA SER UTILIZADO PARA CONECTAR
	 * 
	 */

	public String bancoSelecionado = "BancoAps.db";

	/**
	 * 
	 * PARA FACILITAR A ORGANIZACAO DO btnAdicionar e btnAtualizar
	 */

	private JPanel panel_1;

	/**
	 * 
	 * BOTAO PARA ADICIONAR CAMPOS A MAIS
	 * 
	 */

	public JButton btnAdicionar;

	public Visualizar() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("IndiceQu eimadasICO.png"));// DEFININDO ICONE

		self = this;

		setFont(new Font("Arial", Font.BOLD, 12));// DEFINE UMA FONTE DO PADRAO QUE DESEJO PARA A TELA
		setTitle("Indice De Queimadas");// DEFINE UM TITULO PARA TELA

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// DEFINE UMA OPERACAO PARA FECAHR A TELA
		setSize(800, 400);// DEFINE O TAMANHO DA TELA

		setMinimumSize(new Dimension(800, 400));// DEFINE O MENOR TAMANHO QUE A TELA PDOE FICAR
		setLocationRelativeTo(null);// DEFINE UM LOCAL RELATIVO QUE A TELA FICA POSICIONADA, COMO NULO PARA FICAR
// CENTRALIZADA

		ctnPainelVisualizar = new JPanel();// INSTANCIA UM JPANEL

		ctnPainelVisualizar.setBorder(new EmptyBorder(5, 5, 5, 5));// DEFINE UMA BORDA

		setContentPane(ctnPainelVisualizar);// DEFINE O ctnPainelVisualizar COMO PAINEL DA TELA
		ctnPainelVisualizar.setLayout(new BorderLayout(0, 0));// DEFINE UM TIPO DE LAYOUT PARA O JPANEL

		JLabel label = new JLabel("Total de Queimadas");// CRIA UMA LABEL ESCRITO "Total de Queimadas"
		label.setPreferredSize(new Dimension(150, 45));// DEFINE UM TAMANHO DE PREFERENCIA PARA A label

		label.setHorizontalAlignment(SwingConstants.CENTER);// DEFINE O ALINHAMENTO HORIZONTAL QUE FICARA O TEXTO
		label.setFont(new Font("Tahoma", Font.BOLD, 16));// DEFINE UMA FONTE
		label.setEnabled(false);// DEFINE COMO FALSE PARA NAO SER POSSIVEL SELECIONAR O TEXTO
		ctnPainelVisualizar.add(label, BorderLayout.NORTH);// DEFINE ADICIONA O TEXTO NO JPANEL DEFININDO SUA POSICAO DE

// ALINHAMENTO

		JPanel panel = new JPanel();// INSTANCIA PAINEL(panel)
		ctnPainelVisualizar.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));// DEFINE UM LAYOUT PARA JPANEL

		btnCarregar = new JButton("CARREGAR");// INSTANCIA UM BOTAO NA VARIAVEL btnCarregar E COM TEXTO DE "CARREGAR"
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarBotao();

			}

		});

		btnCarregar.setPreferredSize(new Dimension(150, 45));
		panel.add(btnCarregar, BorderLayout.CENTER);

		btnExportarCSV = new JButton("EXPORTAR	CSV");// INSTANCIA UM BOTAO NA VARIAVEL btnExportarCSV E COM TEXTO DE

		// "EXPORTAR CSV"

		btnExportarCSV.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				exportarCSVBotao();
			}

		});

		panel.add(btnExportarCSV, BorderLayout.EAST);

		btnExportarCSV.setPreferredSize(new Dimension(150, 45));

		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));

		btnAtualizar = new JButton("ATUALIZAR");// INSTANCIA UM BOTAO NA VARIAVEL btnAtualizar E COM TEXTO DE
		panel_1.add(btnAtualizar, BorderLayout.CENTER);

		// "ATUALIZAR"

		btnAtualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				atualizarBotao();
			}

		});

		btnAtualizar.setPreferredSize(new Dimension(150, 45));

		btnAdicionar = new JButton("+");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionarBotao();
			}

		});

		panel_1.add(btnAdicionar, BorderLayout.WEST);

		// NESSE TRECHO ABAIXO INSTANCIO SCROLLPANE E JTABLE PARA FAZER A TABELA
		scrollPane = new JScrollPane();

		ctnPainelVisualizar.add(scrollPane, BorderLayout.CENTER);
		table1 = new JTable();

		modelo = (DefaultTableModel) table1.getModel();
		scrollPane.setViewportView(table1);

	}

	protected void adicionarBotao() {
		// TODO Auto-generated method stub
		
	}

	protected void exportarCSVBotao() {
		// TODO Auto-generated method stub
		
	}

	protected void carregarBotao() {
		// TODO Auto-generated method stub
		
	}

	/**
	 *
	 * 
	 * 
	 * @param ordem A TABELA SERA ORDENADA POR ESTE PARAMETRO.
	 * 
	 */

	public void atualizaTabela(String ordem) {

		DB.connect(bancoSelecionado);// CONECTA COM BANCO DE DADOS

		ResultSet res = DB.query("SELECT * FROM IndiceQueimada ORDER BY " + ordem);// FAZ UM SELECT NA TABELA

//IndiceQueimada, ORDENADO PELA

//	VARIAVEL  ordem

		String[] colunas = { "ID", "DataHora", "Pais", "Estado", "Municipio", "Bioma", "Latitude", "Longitude",
				"Satelite" };// IRA SER O CABEÇARIO DA TABELA

		table1 = new JTable();// INSTANCIA TABELA

		modelo = (DefaultTableModel) table1.getModel();// PEGA MODELO E COLOCA NA VARIAVEL modelo
		scrollPane.setViewportView(table1);// DEFINE O VIEWPORTVIEW DO SCROLL PANE COMO A TABELA

		modelo.setColumnIdentifiers(colunas);// ADICIONA O CABEÇARIO DA TABELA
		TableColumnModel tcm = table1.getColumnModel();// IREI PEGAR MODELO DA COLUNA
		tcm.getColumn(0).setPreferredWidth(35);// IREI DEFINIR UM TAMANHO QUE PREFIRO QUE TENHA A COLUNA
		tcm.getColumn(1).setPreferredWidth(110);// IREI DEFINIR UM TAMANHO QUE PREFIRO QUE TENHA A COLUNA
		tcm.getColumn(4).setPreferredWidth(90);// IREI DEFINIR UM TAMANHO QUE PREFIRO QUE TENHA A COLUNA

		tcm.getColumn(6).setPreferredWidth(50);// IREI DEFINIR UM TAMANHO QUE PREFIRO QUE TENHA A COLUNA
		tcm.getColumn(6).setMaxWidth(50);// IREI DEFINIR UM TAMANHO MAXIMO QUE TENHA A COLUNA

		tcm.getColumn(7).setPreferredWidth(60);// IREI DEFINIR UM TAMANHO QUE PREFIRO QUE TENHA A COLUNA
		tcm.getColumn(7).setMaxWidth(60);// IREI DEFINIR UM TAMANHO MAXIMO QUE TENHA A COLUNA

		tcm.getColumn(8).setPreferredWidth(65);// IREI DEFINIR UM TAMANHO QUE PREFIRO QUE TENHA A COLUNA
		tcm.getColumn(8).setMaxWidth(65);// IREI DEFINIR UM TAMANHO MAXIMO QUE TENHA A COLUNA

		try {

			while (res.next()) {// IREI LER PROXIMA LINHA DO RESULT SET

				String id = res.getString("ID");// NO RESULT SET IREI PEGAR STRING SOLICITADA
				String data = res.getString("DataHora");// NO RESULT SET IREI PEGAR STRING SOLICITADA
				String pais = res.getString("Pais");// NO RESULT SET IREI PEGAR STRING SOLICITADA
				String estado = res.getString("Estado");// NO RESULT SET IREI PEGAR STRING SOLICITADA
				String municipio = res.getString("Municipio");// NO RESULT SET IREI PEGAR STRING SOLICITADA
				String bioma = res.getString("Bioma");// NO RESULT SET IREI PEGAR STRING SOLICITADA
				String latitude = res.getString("Latitude");// NO RESULT SET IREI PEGAR STRING SOLICITADA
				String longitude = res.getString("Longitude");// NO RESULT SET IREI PEGAR STRING SOLICITADA
				String satelite = res.getString("Satelite");// NO RESULT SET IREI PEGAR STRING SOLICITADA
				Object[] objects = { id, data, pais, estado, municipio, bioma, latitude, longitude, satelite };// IREI

// ADICIONAR
// TUDO
// EM UM
//VETOR
//DE
//OBJETOS

				modelo.addRow(objects);// IREI ADICIONAR ESSE VETOR COMO UMA LINHA DA TABELA
			}

		} catch (SQLException e) {// PARA PEGAR ERRO e.printStackTrace();
		}

	}

	protected void atualizarBotao() {
		ArrayList<String[]> stgs = new ArrayList<String[]>();
		for (int i = 0; i < table1.getRowCount(); i++) {// PERCORRENDO A TABELA E ADICIONANDO EM

//ArrayList<String[]> stgs OS DADOS

			String[] sData = { table1.getValueAt(i, 0).toString(), table1.getValueAt(i, 1).toString(),
					table1.getValueAt(i, 2).toString(), table1.getValueAt(i, 3).toString(),
					table1.getValueAt(i, 4).toString(), table1.getValueAt(i, 5).toString(),
					table1.getValueAt(i, 6).toString(), table1.getValueAt(i, 7).toString(),
					table1.getValueAt(i, 8).toString() };
			stgs.add(sData);
		}

		new Thread() {

			@Override

			public void run() {
				int iIdata = 1;
// DESATIVANDO OS BOTOES ATE FIM DO PROCESSO

				btnCarregar.setEnabled(false);
				btnAtualizar.setEnabled(false);
				btnExportarCSV.setEnabled(false);
				btnAdicionar.setEnabled(false);
				Fila f = new Fila(stgs.size());// INICIANDO FILA COM TAMANHO DA ArrayList<String[]> stgs

				for (String[] data : stgs) {// PERCORRENDO stgs

					for (int i = 0; i < data.length; i++) {// PERCORRENDO AS String[] data
						data[i].replaceAll("'", "''");// TROCANDO TODOS "'" PARA "''"
					}
					f.inserir("UPDATE IndiceQueimada SET DataHora = '" + data[1] + "' ,Pais = '" + data[2]
							+ "'	,Estado	=	'" + data[3].replaceAll("'", "''") + "' ,Municipio = '" + data[4]
							+ "' ,Bioma = '" + data[5] + "' ,Latitude = " + data[6] + " ,Longitude = " + data[7]
							+ " ,Satelite = '" + data[8] + "' WHERE ID = " + iIdata);// INSERINDO NA FILA EM

					// FORMATO DE STRING O
					// COMANDO UPDATE
					iIdata++;
				}
				while (!f.isEmpty())
					DB.execQuery(f.retirar());// RETIRANDO DA FILA E EXECUTANDO

				// ATIVANDO OS BOTOES

				btnCarregar.setEnabled(true);
				btnAtualizar.setEnabled(true);
				btnExportarCSV.setEnabled(true);
				btnAdicionar.setEnabled(true);
			}

		}.start();

	}
/*
	protected void exportarCSVBotao() {
		if (localCSV.isEmpty()) {
	
				do {

				localCSV = FileChooser.FileChooserSave();// PARA USUARIO SELECIONAR .CSV

				}while(!localCSV.toUpperCase().endsWith(".CSV"));//	PARA	OBRIGAR SELECIONAR NO FORMATO CERTO		

				ArrayList<String> arrayOrdenarCSV = new ArrayList<String>();
				 
				ArrayList<Integer> arrayOrdenarPosicaoCSV = new ArrayList<Integer>();
				for (int iTY = 0; iTY < table1.getRowCount();
				iTY++) {

				String ordenarCSV = "";

				for	(int	iTX	=	0;	iTX	< table1.getColumnCount(); iTX++) {
				ordenarCSV += table1.getValueAt(iTY,
				iTX) + ";";

				}

				arrayOrdenarCSV.add(iTY, ordenarCSV);

				int	iAOPCSV	= Integer.parseInt(table1.getValueAt(iTY, 0).toString());
				arrayOrdenarPosicaoCSV.add(iTY, iAOPCSV);

				}

				Ordenadores ordArray = new Ordenadores();



				String[] escolhas1 = { "Quick Sort", "Insertion Sort" };// ESCOLHAS
				String input1 = "Quick Sort"; do {
				input1	=		(String)
				JOptionPane.showInputDialog(null,	"Deseja	ordenar	por	qual algoritmo de ordenacao?",			

				"Escolha", JOptionPane.QUESTION_MESSAGE, null, escolhas1, escolhas1[0]);
				} while (input1 == null || input1.isEmpty());// OBRIGA USUARIO A ESCOLHA
				long tempoInicial;// VARIAVEL PARA  ARMAZENAR TEMPO INICIAL
				 
				long tempoFinal;// VARIAVEL PARA ARMAZENAR TEMPO FINAL

				long tempoPercorrido;// VARIAVEL PARA ARMAZENAR GUARDAR O TEMPO PERCORRIDO


				switch (input1){// PARA AGIR BASEADO NA ESCOLHA case "Quick Sort":
				tempoInicial = System.currentTimeMillis();// DEFININDO UM VALOR PRO TEMPO INCIAL

				arrayOrdenarCSV	=
				ordArray.quickArray(arrayOrdenarPosicaoCSV, 0,

				arrayOrdenarPosicaoCSV.size() - 1, arrayOrdenarCSV);// ORDENANDO arrayOrdenarCSV POR


//MEIO DE RAPIDA(QUICKSORT, QUICK SORT)

				tempoFinal = System.currentTimeMillis();// DEFININDO UM VALOR PRO TEMPO FINAL
				tempoPercorrido	=	tempoFinal	- tempoInicial;// DEFININDO UM VALOR PRO TEMPO PERCORRIDO
				SimpleDateFormat	dateFormat	=	new SimpleDateFormat("HH:mm:ss:SSSSSSS");


				dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

				JOptionPane.showMessageDialog(null,

				"Tempo para ordenar Quick Sort: "
				+ dateFormat.format(new Date(tempoPercorrido)));// MOSTRANDO
				// TEMPO

				// PERCORRIDO

				break;

					
				case "Insertion Sort":

				tempoInicial	=
				System.currentTimeMillis();// DEFININDO UM VALOR PRO TEMPO INCIAL

				arrayOrdenarCSV	=
				ordArray.insertArray(arrayOrdenarPosicaoCSV, arrayOrdenarCSV);// ORDENANDO
				
				// arrayOrdenarCSV
				// POR
				// MEIO
				// DE
				// INSERCAO(INSERTIONSORT,
				// INSERTION				 
				// SORT)

				tempoFinal = System.currentTimeMillis();// DEFININDO UM VALOR PRO TEMPO FINAL
				tempoPercorrido	=	tempoFinal	- tempoInicial;// DEFININDO UM VALOR PRO TEMPO PERCORRIDO
				dateFormat	= new SimpleDateFormat("HH:mm:ss:SSSSSSS");//	FORMATO	QUE	SERA CONVERTIDO O TEMPO			


				// PERCORRIDO
				dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
				JOptionPane.showMessageDialog(null,	"Tempo para ordenar Insertion Sort: " + dateFormat.format(new Date(tempoPercorrido)));// MOSTRANDO

				// TEMPO
				// PERCORRIDO
				break; 
				default:
				break;
				}

				String	salvarArrayOrdenarCSV	= "id;datahora;pais;estado;municipio;bioma;latitude;longitude;sate lite;\n";
				// INICIANDO
				// COM
				// CABECARIO
				for (int i = 0; i < arrayOrdenarCSV.size(); i++)
					salvarArrayOrdenarCSV	+=arrayOrdenarCSV.get(i) + "\n";
				// FAZENDO LOOPING PARA PASSAR O
				//	salvarArrayOrdenarCSV PARA STRING
				
				Arquivo.CriarCSV(localCSV, salvarArrayOrdenarCSV);// CRIANDO O ARQUIVO .CSV
				} else {
				ArrayList<String>	arrayOrdenarCSV	=	new ArrayList<String>();
				ArrayList<Integer> arrayOrdenarPosicaoCSV = new ArrayList<Integer>();
				for (int iTY = 0; iTY < table1.getRowCount();
				iTY++) {

				String ordenarCSV = "";

				for	(int	iTX	=	0;	iTX	< table1.getColumnCount(); iTX++) {
				ordenarCSV += table1.getValueAt(iTY,
				iTX) + ";";

				}

				arrayOrdenarCSV.add(iTY, ordenarCSV);

				int	iAOPCSV	= Integer.parseInt(table1.getValueAt(iTY, 0).toString());
				arrayOrdenarPosicaoCSV.add(iTY, iAOPCSV);

				}
				Ordenadores ordArray = new Ordenadores(); arrayOrdenarCSV	=
				ordArray.insertArray(arrayOrdenarPosicaoCSV, arrayOrdenarCSV);



				String[] escolhas1 = { "Quick Sort", "Insertion Sort" };// ESCOLHAS
				String input1 = "Quick Sort"; do {
				input1	=		(String)
				JOptionPane.showInputDialog(null,	"Deseja	ordenar	por	qual algoritmo de ordenacao?",			

				"Escolha", JOptionPane.QUESTION_MESSAGE, null, escolhas1, escolhas1[0]);
				} while (input1 == null || input1.isEmpty());

				long tempoInicial;// VARIAVEL PARA  ARMAZENAR TEMPO INICIAL

				long tempoFinal;// VARIAVEL PARA ARMAZENAR TEMPO FINAL

				long tempoPercorrido;// VARIAVEL PARA ARMAZENAR GUARDAR O TEMPO PERCORRIDO


				switch (input1) {// PARA AGIR BASEADO NA ESCOLHA case "Quick Sort":
				tempoInicial = System.currentTimeMillis();

				arrayOrdenarCSV	=
				ordArray.quickArray(arrayOrdenarPosicaoCSV, 0,
						arrayOrdenarPosicaoCSV.size() - 1, arrayOrdenarCSV);// ORDENANDO arrayOrdenarCSV POR
				//MEIO DE RAPIDA(QUICKSORT, QUICK SORT)

			tempoFinal = System.currentTimeMillis();

			tempoPercorrido	= tempoFinal - tempoInicial;

			SimpleDateFormat dateFormat	= new SimpleDateFormat("HH:mm:ss:SSSSSSS");
			dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			JOptionPane.showMessageDialog(null,"Tempo para ordenar Quick Sort: "+ dateFormat.format(new Date(tempoPercorrido)));
			break;	
			
			case "Insertion Sort":

			tempoInicial			

			=
			System.currentTimeMillis();// DEFININDO INICIAL	UM VALOR	PRO TEMPO	
			arrayOrdenarCSV			=
			ordArray.insertArray(arrayOrdenarPosicaoCSV, arrayOrdenarCSV);// ORDENANDO
			// arrayOrdenarCSV
			// POR			 
			// MEIO
			// DE
			// INSERCAO(INSERTIONSORT,
			// INSERTION
			// SORT)

			tempoFinal = System.currentTimeMillis();// DEFININDO UM VALOR PRO TEMPO FINAL
			tempoPercorrido	=	tempoFinal	- tempoInicial; // DEFININDO UM VALOR PRO TEMPO PERCORRIDO

			dateFormat = new
			SimpleDateFormat("HH:mm:ss:SSSSSSS");//	FORMATO	QUE	SERA CONVERTIDO O TEMPO	
			// PERCORRIDO
			dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			JOptionPane.showMessageDialog(null,"Tempo para ordenar Insertion Sort: " + dateFormat.format(new Date(tempoPercorrido)));
			break; 
			default:			 
				break;
				}
				String	salvarArrayOrdenarCSV	= "id;datahora;pais;estado;municipio;bioma;latitude;longitude;sate lite;\n";// INICIANDO
				// COM
				// CABECARIO
				for (int i = 0; i < arrayOrdenarCSV.size(); i++) salvarArrayOrdenarCSV	+=
				arrayOrdenarCSV.get(i) + "\n";// FAZENDO LOOPING PARA PASSAR O
				// salvarArrayOrdenarCSV PARA STRING

				Arquivo.CriarCSV(localCSV, salvarArrayOrdenarCSV);// CRIANDO O ARQUIVO .CSV
				
				}

	protected void carregarBotao() {

				String[] escolhas1 = { "SQL", "CSV" };// ESCOLHAS String input1 = "SQL";
				do {// PARA USUARIO FAZER UMA ESCOLHA

				input1 = (String) JOptionPane.showInputDialog(null, "Deseja carregar a partir de qual base?", "Escolha",
				 
						JOptionPane.QUESTION_MESSAGE,	null,
						escolhas1, escolhas1[0]);

						} while (input1 == null || input1.isEmpty());// LOOPING ATE USUARIO TER FEITO A ESCOLHA
						switch (input1) {// PARA AGIR BASEADO NA ESCOLHA case "SQL":
						String[] escolhas2 = { "ID", "DataHora", "Pais", "Estado", "Municipio", "Bioma", "Latitude", "Longitude",
						"Satelite" };// ESCOLHAS String input2 = "ID";
						do {// PARA USUARIO FAZER UMA ESCOLHA
						input2 = (String)
						JOptionPane.showInputDialog(null, 
								"Deseja ordenar por qual campo?",
								"Escolha",
								JOptionPane.QUESTION_MESSAGE,
								null,
								escolhas2,
								escolhas2[0]);
						} while (input2 == null || input2.isEmpty());// LOOPING ATE USUARIO TER FEITO A ESCOLHA
						self.atualizaTabela(input2);
						break;
						case "CSV":

						if (localCSV.isEmpty()) { 
							do {
						}
						localCSV = FileChooser.FileChooserSave();// USUARIO SELECIONAR O LOCAL DO
						.CSV

						}		while
						(!localCSV.toUpperCase().endsWith(".CSV"));// PARA	OBRIGAR	SELECIONAR NO FORMATO CERTO
						}
						
	CSVFile csvFile = new CSVFile();// INICIANDO CLASSE PARA LER CSV
	ArrayList<String[]> stgs = csvFile.readToList(localCSV, ";");// LENDO CSV E ATACANDO EM

	// ArrayList<String[]> stgs

	AlimentarBanco alimentarBD = new AlimentarBanco();// INICANDO CLASSE UTILZADA PARA ATUALIZAR O BANCO

	// E ESTA CLASSE UTILIZA PILHA

	alimentarBD.alimentarCSV(stgs);// PARA ATUALIZAR O BANCO DE DADOS A PARTIR DO .CSV

	String[] escolhas3 = { "ID", "DataHora", "Pais", "Estado", "Municipio", "Bioma", "Latitude", "Longitude","Satelite" };// ESCOLHAS String input3 = "ID";
	do
	{

		input3 = (String) JOptionPane.showInputDialog(null, "Deseja	ordenar	por	qual campo?", "Escolha",
				JOptionPane.QUESTION_MESSAGE, null, escolhas3, escolhas3[0]);

	}while(input3==null||input3.isEmpty());self.atualizaTabela(input3);
	break;

	default:atualizaTabela("ID");
	break;
	

	}

	protected void adicionarBotao() {
		new Thread() {
			@Override

			public void run() {

				// DESATIVANDO OS BOTOES ATE FIM DO PROCESSO

				btnCarregar.setEnabled(false);
				btnAtualizar.setEnabled(false);
				btnExportarCSV.setEnabled(false);
				btnAdicionar.setEnabled(false);
				DB.connect(bancoSelecionado);// CONECTA COM BANCO DE DADOS

				ResultSet res = DB.query("SELECT * FROM	IndiceQueimada");

				int iRes = 1;
				try {
					while (res.next())
						iRes++;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				int input1;
				do {
					input1 = Integer.parseInt("0" + (String) JOptionPane.showInputDialog(null,
							"Quantos	deseja adicionar?", "Escolha", JOptionPane.QUESTION_MESSAGE));
				} while (input1 <= 0);
				int iInput1 = 0;
				Fila f = new Fila(input1);// INICIANDO FILA COM TAMANHO DA ArrayList<String[]> stgs

				while (input1 > iInput1) {
					f.inserir(
							"INSERT INTO IndiceQueimada (ID, DataHora, Pais, Estado, Municipio, Bioma, Latitude, Longitude, Satelite) VALUES ("
									+ (iRes + iInput1)
									+ ", '2000/01/01 00:00:00', 'NULL', 'NULL', 'NULL', 'NULL', 0, 0, 'NULL')");
					iInput1++;
				}
				while (!f.isEmpty())
					DB.execQuery(f.retirar());// RETIRANDO DA FILA E EXECUTANDO

				// ATIVANDO OS BOTOES
				btnCarregar.setEnabled(true);
				btnAtualizar.setEnabled(true);
				btnExportarCSV.setEnabled(true);
				btnAdicionar.setEnabled(true);
				atualizaTabela("ID");
			}
		}.start();
	}
*/
}
