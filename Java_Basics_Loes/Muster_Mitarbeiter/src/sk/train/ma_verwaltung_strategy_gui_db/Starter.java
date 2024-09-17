package sk.train.ma_verwaltung_strategy_gui_db;

import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Starter {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		
		Connection con = DBConnect.createConnection();
		
		//Shutdown-Hook für Schließen der Connection, 
				//damit später die GUI richtig funktioniert
				Runtime.getRuntime().addShutdownHook(new Thread(() -> {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}));

		MitarbeiterVerwaltung mv = new MitarbeiterVerwaltung(con);
		
		JFrame frame = new JFrame("Mitarbeiter-Tabelle");
		JTable table = new JTable(new MitarbeiterTableModel(mv));
		JScrollPane scrollp = new JScrollPane(table);
		frame.add(scrollp, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		//f.pack();
		frame.setVisible(true);
		
		//Test von CREATE und DELETE, noch ohne GUI-Aktualisierung
		Mitarbeiter neu = new Mitarbeiter(1, "Max", "Muster", LocalDate.of(2000,1,1), LocalDate.now(), Geschlecht.M, new FixGehaltModell(new BigDecimal(1000)));
		mv.addMitarbeiter(neu);
		
		Thread.sleep(120_000);
		
		mv.delMitarbeiter(neu);
		
		
		

	}

}
