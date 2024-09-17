package sk.train.ma_verwaltung_strategy_gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Starter {

	public static void main(String[] args) {

		MitarbeiterVerwaltung mv = new MitarbeiterVerwaltung();
		
		JFrame frame = new JFrame("Mitarbeiter-Tabelle");
		JTable table = new JTable(new MitarbeiterTableModel(mv));
		JScrollPane scrollp = new JScrollPane(table);
		frame.add(scrollp, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		//f.pack();
		frame.setVisible(true);

	}

}
