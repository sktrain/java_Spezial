package sk.train.ma_verwaltung_strategy_gui_db;

import java.util.Comparator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MitarbeiterTableModel extends AbstractTableModel {
		
	private List<Mitarbeiter> mlist;

	public MitarbeiterTableModel(MitarbeiterVerwaltung mv) {
		super();
		mlist = mv.getMlist(Comparator.naturalOrder());
	}

	@Override
	public int getRowCount() {
		return mlist.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			Mitarbeiter m = mlist.get(rowIndex);
			if (columnIndex == 0) {
				return m.getPersnr();
			}
			if (columnIndex == 1) {
				return m.getVorname();
			}
			if (columnIndex == 2) {
				return m.getNachname();
			}
			if (columnIndex == 3) {
				return m.getGebdatum();
			}
			if (columnIndex == 4) {
				return m.getEinstdatum();
			}
			if (columnIndex == 5) {
				return m.getGeschlecht();
			}
			if (columnIndex == 6) {
				return m.getGmodell().getGehalt();
			}
	        return null;
		}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "Persnr";
		}
		if (columnIndex == 1) {
			return "Vorname";
		}
		if (columnIndex == 2) {
			return "Nachname";
		}
		if (columnIndex == 3) {
			return "Gebdatum";
		}
		if (columnIndex == 4) {
			return "Einstdatum";
		}
		if (columnIndex == 5) {
			return "Geschlecht";
		}
		if (columnIndex == 6) {
			return "Gehalt";
		}
        return null;
	}
	}

	
	
	
	

