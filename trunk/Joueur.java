/*
Exemple d'impl�mentation d'un joueur d'Othello. Cette impl�mentation sert uniquement
� d�montrer le principe, mais n'impl�mente aucune intelligence: les coups � jouer sont
simplement lus � la console!
*/

// Votre version sera dans Participants.<VosNoms>

package Participants.FroidevauxKaluznyNeuhaus;

// Pour l'interop�rabilit�: il faut une repr�sentation commune des coups!
import java.util.Scanner;

import Othello.Move;

// Vous devrez �tendre Othello.Joueur pour impl�menter votre propre joueur...
public class Joueur extends Othello.Joueur
	{

	// depth: profondeur alpha-beta
	// playerID: 0 = rouge, 1 = bleu
	public Joueur(int depth, int playerID)
		{
		super();
		}

	Scanner stdin = new Scanner(System.in);

	// M�thode appel�e � chaque fois que vous devez jouer un coup.
	@Override public Move nextPlay(Move move)
		{
		// Ici, vous devrez
		// - Mettre � jour votre repr�sentation du jeu en fonction du coup jou� par l'adversaire
		// - D�cider quel coup jouer (alpha-beta!!)
		// - Remettre � jour votre repr�sentation du jeu
		// - Retourner le coup choisi
		// Mais ici, on se contente de lire � la console:
		Move result = null;
		if (move != null)
			{
			System.out.println("Coup adverse: " + move.i + ", " + move.j);
			}
		System.out.println("Votre coup: ");
		System.out.print("Colonne (-1 si aucun coup possible): ");
		int i = stdin.nextInt();
		if (i != -1)
			{
			System.out.print("Ligne: ");
			int j = stdin.nextInt();
			result = new Move(i, j);
			}
		return result;
		}

	}
