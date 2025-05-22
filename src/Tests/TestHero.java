package Tests;

import heros.*;
import gestionEffets.*;

public class TestHero {

    public static void main(String[] args) {
        testAttributionPouvoirHeroique();
    }

    static void testAttributionPouvoirHeroique() {
        // Test for Mage
        Hero heroMage = new Hero();
        if (heroMage.getPouvoir() instanceof PouvoirMage) {
            System.out.println("Test Mage: PASSED");
            System.out.println("Pouvoir: " + heroMage.getPouvoir().getNomPouvoir());
        } else {
            System.out.println("Test Mage: FAILED");
        }

        // Test for Prêtre
        Hero heroPretre = new Hero();
        if (heroPretre.getPouvoir() instanceof PouvoirPretre) {
            System.out.println("Test Prêtre: PASSED");
            System.out.println("Pouvoir: " + heroPretre.getPouvoir().getNomPouvoir());
        } else {
            System.out.println("Test Prêtre: FAILED");
        }

        // Test for Guerrier
        Hero heroGuerrier = new Hero();
        if (heroGuerrier.getPouvoir() instanceof PouvoirGuerrier) {
            System.out.println("Test Guerrier: PASSED");
            System.out.println("Pouvoir: " + heroGuerrier.getPouvoir().getNomPouvoir());
        } else {
            System.out.println("Test Guerrier: FAILED");
        }

        // Test for Voleur
        Hero heroVoleur = new Hero();
        if (heroVoleur.getPouvoir() instanceof PouvoirVoleur) {
            System.out.println("Test Voleur: PASSED");
            System.out.println("Pouvoir: " + heroVoleur.getPouvoir().getNomPouvoir());
        } else {
            System.out.println("Test Voleur: FAILED");
        }

        // Test for Paladin
        Hero heroPaladin = new Hero();
        if (heroPaladin.getPouvoir() instanceof PouvoirPaladin) {
            System.out.println("Test Paladin: PASSED");
            System.out.println("Pouvoir: " + heroPaladin.getPouvoir().getNomPouvoir());
        } else {
            System.out.println("Test Paladin: FAILED");
        }

        // Test for Chasseur
        Hero heroChasseur = new Hero();
        if (heroChasseur.getPouvoir() instanceof PouvoirChasseur) {
            System.out.println("Test Chasseur: PASSED");
            System.out.println("Pouvoir: " + heroChasseur.getPouvoir().getNomPouvoir());
        } else {
            System.out.println("Test Chasseur: FAILED");
        }

        // Test for Druide
        Hero heroDruide = new Hero();
        if (heroDruide.getPouvoir() instanceof PouvoirDruide) {
            System.out.println("Test Druide: PASSED");
            System.out.println("Pouvoir: " + heroDruide.getPouvoir().getNomPouvoir());
            
        } else {
            System.out.println("Test Druide: FAILED");
            
        }

    }
}
