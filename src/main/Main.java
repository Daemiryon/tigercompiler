package main;

import main.java.parser.tigerLexer;
import main.java.parser.tigerParser;
import main.java.parser.tigerParser.ProgramContext;

import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

public class Main {

  public static void main(String[] args) {

    if (args.length < 1) {
      System.out.println("Error : Expected 1 argument filepath, found 0");
      return;
    }

    String testFile = args[0];

    try {

      // chargement du fichier et construction du parser

      CharStream input = CharStreams.fromFileName(testFile);
      tigerLexer lexer = new tigerLexer(input);
      CommonTokenStream stream = new CommonTokenStream(lexer);
      tigerParser parser = new tigerParser(stream);

      // Récupération du noeud program (le noeud à la racine)
      ProgramContext program = parser.program();

      // code d'affichage de l'arbre syntaxique
      JFrame frame = new JFrame("Antlr AST");
      JPanel panel = new JPanel();
      TreeViewer viewer = new TreeViewer(Arrays.asList(
          parser.getRuleNames()), program);
      viewer.setScale(1.5); // Scale a little
      panel.add(viewer);
      frame.add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (RecognitionException e) {
      e.printStackTrace();
    }

  }

}