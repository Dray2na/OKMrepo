package sonok.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import sonok.global.guiMenuNode;
import sonok.gui.GUI_LogIn;
import sonok.gui.GUI_Menu;
import sonok.gui.GUI_Menu_Entry;
	
public class Main {
	public static ContentManager Manager;
	public static MainFrame Frame;
	public static GUI_Menu Menu;
	public static GUI_LogIn LogIn;
	
	public static void main(String[] args) {
//		Programmstart
		Init();
	}
	
	private static void Init() {
//		Hier werden die Hauptobjekte erstellt
			Manager = new ContentManager();
			Frame = new MainFrame();
			Menu = new GUI_Menu();
			//LogIn = new GUI_LogIn();
		
//		Menü im Frame anhängen, MainFrame verwaltet das Menü und die Panels
		Frame.setMenu(Menu);
		
//		Lest euch bitte mal die Funktion durch
		makeMenu_Mit_Kommentaren();
//		Danach könnt ihr diese Benutzen:
		//makeMenu();
	}
	
	private static void makeMenu_Mit_Kommentaren() {
//	Hier wird die Verwendung des Menüs erklärt
//	Lest euch die Kommentare am besten mal durch
//		
//	Später müssen diese Einträge durch den Content Manager erstellt werden.
//
//	Für einen Menüeintrag verwendet GUI_Menu_Entry
//	Die Klasse wird wird prinzipiell so erstellt:
//		new GUI_Menu_Entry( Text, Icon / Bild, Größe / GrößeOffen, ClickEvent )
//		
//		Es gibt zahlreiche Konstruktoren, sodass
//		ihr schon beim Erstellen einige Entscheidungen
//		über das Design treffen könnt.
//		
//	Zum einfügen von Menüeinträgen  in das Hauptmenü
//	verwendet Menu.addEntry( GUI_Menu_Entry )
//			
//	Hier wird der Kopf erstellt
//		Zuerst ein 10 Pixel hoher, Oranger Balken.
		Menu.addEntry(new GUI_Menu_Entry(10)).setBackground(new Color(255, 128, 0));
		
//		Der Header bekommt eine Beschriftung, kein Icon, aber einen Hintergrund,
//		wenn ihr den Konstruktor so benutzt, wird das Bild über die ganze Fläche gestreckt.
		GUI_Menu_Entry header = Menu.addEntry(new GUI_Menu_Entry("sonok", "", "wallpaper", 40, null));
//			Um sie weiter zu bearbeiten kann man
//			Menüpunkte in eine Variable ablegen.
			header.setForeground(Color.WHITE);
			
//		Der nächste Eintrag hat ein Icon. Die liegen alle in "Sonok/data/icon/"
//		Ich habe Icons aus einem alten Projekt genommen, wir können ja noch eigene machen	
//			Außerdem hat dieses Icon keinen Rand
//			Hier wäre ein kleines Profilbild nice
		Menu.addEntry(new GUI_Menu_Entry("Mister Mustermann", "user", null)).setMargin(0);
		
		
		//Weitere beispieleinträge
		GUI_Menu_Entry wiki = Menu.addEntry(new GUI_Menu_Entry("Wiki", "book", null));
		GUI_Menu_Entry nachrichten = Menu.addEntry(new GUI_Menu_Entry("Nachrichten", "note", null));
		GUI_Menu_Entry aufgaben = Menu.addEntry(new GUI_Menu_Entry("Projekte", "project", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Bürgermeister der Film", "task", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Filmprojektfindung", "prio", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Nichtstun", "task", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Granatapfelmanagement", "task", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Ente Ente Ente Ente Ente Ente Ente", "prio", null));

//			Einstellungen
			final GUI_Menu_Entry settings = Menu.addEntry(new GUI_Menu_Entry("Einstellungen", "settings", null));	
			
//				So kann man einem Menüpunkt eine Funktion hinzufügen
				Menu.addEntryChild(settings,new GUI_Menu_Entry("Panel+", 24, new Thread(){
					@Override
					public void run() {
//						Dieser Menüeintrag fügt ein Panel in das Frame ein
//						So könnt ihr eure Panels im Programm testen
						Frame.addPanel(new GUI_LogIn(),settings);
					}
				})).setMargin(0);
				
				Menu.addEntryChild(settings,new GUI_Menu_Entry("Panel-", 24, new Thread(){
					@Override
					public void run() {
//						Diese Funktion ist Global und schließt alle Panels
						Frame.clearPanels();
					}
				})).setMargin(0);		
//			Programm beenden button
			Menu.addEntry(new GUI_Menu_Entry("Schließen", "close", new Thread(){
				@Override
				public void run() {
					System.exit(0);
				}
			})).setMargin(0);
	}
}
