package com.formationandroid.sauvegardeactivite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity()
{

	companion object
	{
		// Constantes :
		private const val VALEUR_DE_MIN = 1
		private const val VALEUR_DE_MAX = 6
		private const val VALEUR_DE_1 = "VALEUR_DE_1"
		private const val VALEUR_DE_2 = "VALEUR_DE_2"
		private const val VALEUR_DE_3 = "VALEUR_DE_3"
	}

	// Valeurs des dés :
	private var valeurDe1 = 0
	private var valeurDe2 = 0
	private var valeurDe3 = 0


	override fun onCreate(savedInstanceState: Bundle?)
	{
		// init :
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		// valeurs aléatoires :
		if (savedInstanceState != null)
		{
			// récupération des valeurs sauvegardées :
			valeurDe1 = savedInstanceState.getInt(VALEUR_DE_1)
			valeurDe2 = savedInstanceState.getInt(VALEUR_DE_2)
			valeurDe3 = savedInstanceState.getInt(VALEUR_DE_3)
		}
		else
		{
			// initialisation si première exécution :
			valeurDe1 = Random.Default.nextInt(VALEUR_DE_MAX) + VALEUR_DE_MIN
			valeurDe2 = Random.Default.nextInt(VALEUR_DE_MAX) + VALEUR_DE_MIN
			valeurDe3 = Random.Default.nextInt(VALEUR_DE_MAX) + VALEUR_DE_MIN
		}

		// affichage :
		de_1.text = valeurDe1.toString()
		de_2.text = valeurDe2.toString()
		de_3.text = valeurDe3.toString()
	}

	override fun onSaveInstanceState(outState: Bundle)
	{
		// appel obligatoire :
		super.onSaveInstanceState(outState)

		// sauvegarde :
		outState.putInt(VALEUR_DE_1, valeurDe1)
		outState.putInt(VALEUR_DE_2, valeurDe2)
		outState.putInt(VALEUR_DE_3, valeurDe3)
	}

}