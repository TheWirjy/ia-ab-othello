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

	private Board rootBoard;

	// depth: profondeur alpha-beta
	// playerID: 0 = rouge, 1 = bleu
	public Joueur(int depth, int playerID)
		{
		super();
		rootBoard = new Board(1, 2, 2, 0);
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
		rootBoard.applyOp(move);
		if (move != null)
			{
			System.out.println("Coup adverse: " + move.i + ", " + move.j);
			}
		System.out.println("Votre coup: ");
		System.out.print("Colonne (-1 si aucun coup possible): ");
		/*int i = stdin.nextInt();
		if (i != -1)
			{
			System.out.print("Ligne: ");
			int j = stdin.nextInt();
			result = new Move(i, j);
			}*/

		return alphabeta(rootBoard, 5, rootBoard, rootBoard.evalBoard()).getMove();//result;
		}

	// minormax = 1: maximize
	// minormax = -1: minimize
	// TODO: must return a couple (BoardEval, Move)
	public AlphaBetaReturnValues alphabeta(Board root, int depth, int minormax, int parentValue)
		{
		if (depth == 0 || root.isFinal())
			{
			// Retourne l'�valuation de la grille et il n'y a plus de coups possibles
			return new AlphaBetaReturnValues(null, root.evalBoard());
			}
		int optVal = minormax * -Integer.MIN_VALUE;
		Move optOp = null;

		for(Move op:root.findAvailableMoves())
			{
			Board newState = new Board(root, op);
			AlphaBetaReturnValues returnValues;
			returnValues = alphabeta(newState, depth-1, -minormax, optVal);

			if (returnValues.getEvalValue()*minormax > optVal * minormax)
				{
				optVal = returnValues.getEvalValue();
				optOp = returnValues.getMove();
				if (optVal*minormax > parentValue * minormax)
					{
					break;
					}
				}
			}
		return new AlphaBetaReturnValues(optOp, optVal);
		}
	}