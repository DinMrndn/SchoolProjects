package pokemongame;

import java.util.*;

public class PokemonGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        pokemons PlayerPokemon = new pokemons(); // Player's pokemon
        pokemons EnemyPokemon = new pokemons(); // Enemy's pokemon

        while (1 == 1) {

            int enemyNum = r.nextInt(3) + 1;

            System.out.println("What is your name?");
            String player_name = sc.nextLine();
            String enemy_name = "Ash";

            //ENEMY POKEMON SET
            if (enemyNum == 1) {
                EnemyPokemon.setPokemon("Torchic", 100, "Ember", "Scratch", "Flame Burst");
            } else if (enemyNum == 2) {
                EnemyPokemon.setPokemon("Mudkip", 100, "Bide", "Whirlpool", "Mud Sport");
            } else if (enemyNum == 3) {
                EnemyPokemon.setPokemon("Treecko", 100, "Leech Seed", "Slam", "Giga Drain");
            }

            while (1 == 1) {
                System.out.println("Which pokemon do you want to choose?");
                System.out.println("1. Squirtle\n2. Charmander \n3. Bulbasaur");
                int pokemon_number = sc.nextInt();
                //PLAYER POKEMON SET
                if (pokemon_number == 1) {
                    PlayerPokemon.setPokemon("Squirtle", 100, "Water gun", "Bubble", "Hydro Pump");
                    break;
                } else if (pokemon_number == 2) {
                    PlayerPokemon.setPokemon("Charmander", 100, "Ember", "Fire Spin", "Flame Thrower");
                    break;
                } else if (pokemon_number == 3) {
                    PlayerPokemon.setPokemon("Bulbasaur", 100, "Leech Seed", "Razor Leaf", "Vine Whip");
                    break;
                } else {
                    System.out.println("Invalid pokemon number!");
                }
            }
            delay(500);
            System.out.println(player_name + " chose " + PlayerPokemon.getName() + "!");
            System.out.println(enemy_name + " chose " + EnemyPokemon.getName() + "!");
            System.out.println("EVERY POKEMON STARTS WITH 100 HEALTH");
            System.out.println("=============================================");
            int c = r.nextInt(2) + 1;
            System.out.println("Coin Tossed...");
            delay(1000);
            boolean userTurn = false;

            if (c == 1) {
                System.out.println(player_name + " won the toss coin and will attack first!");
                userTurn = true;
                System.out.println("=============================================");
            } else if (c == 2) {
                System.out.println(enemy_name + " won the toss coin and will attack first!");
                System.out.println("=============================================");
            }

            while (1 == 1) {
                int damage = 0;
                int enemy_damage = 0;
                String skill = "";
                String enemyskill = "";

                if (userTurn) {
                    System.out.println("What skill do you want " + PlayerPokemon.getName() + " to use?");
                    System.out.println("1. " + PlayerPokemon.getSkill1());
                    System.out.println("2. " + PlayerPokemon.getSkill2());
                    System.out.println("3. " + PlayerPokemon.getSkill3());

                    while (1 == 1) {
                        int sknum = sc.nextInt();

                        if (sknum == 1) {
                            skill = PlayerPokemon.getSkill1();
                            damage = r.nextInt(25) + 1;
                            break;
                        } else if (sknum == 2) {
                            skill = PlayerPokemon.getSkill2();
                            damage = r.nextInt(10) + 20;
                            break;
                        } else if (sknum == 3) {
                            skill = PlayerPokemon.getSkill3();
                            damage = r.nextInt(30) + 1;
                            break;
                        } else {
                            System.out.println("Skill error enter a number.");
                        }
                    }
                    System.out.println("=============================================");
                    System.out.println(PlayerPokemon.getName() + " used " + skill + " on " + EnemyPokemon.getName());

                    if (damage >= 25) {
                        System.out.println("A Critical Hit! " + damage + " damage.");
                    } else {
                        System.out.println(damage + " damage.");
                    }
                    EnemyPokemon.health = EnemyPokemon.getHealth() - damage;
                    System.out.println(EnemyPokemon.getName() + " is left with " + EnemyPokemon.getHealth() + "HP");

                    System.out.println("=============================================");
                    if (EnemyPokemon.health <= 0) {
                        System.out.println(EnemyPokemon.getName() + " fainted and cant continue.");
                        System.out.println(enemy_name + " lost the duel.");
                        System.out.println("=============================================");
                        break;
                    }
                }

                int epnum = r.nextInt(3) + 1;
                if (epnum == 1) {
                    enemyskill = EnemyPokemon.getSkill1();
                    enemy_damage = r.nextInt(25) + 1;
                } else if (epnum == 2) {
                    enemyskill = EnemyPokemon.getSkill2();
                    enemy_damage = r.nextInt(10) + 20;
                } else if (epnum == 3) {
                    enemyskill = EnemyPokemon.getSkill3();
                    enemy_damage = r.nextInt(30) + 1;
                }
                delay(1000);
                System.out.println(enemy_name + "'s Turn.");
                delay(1500);
                System.out.println(enemy_name + " ordered " + EnemyPokemon.getName() + " to use " + enemyskill);
                System.out.println("=============================================");
                delay(1000);
                System.out.println(EnemyPokemon.getName() + " used " + enemyskill + " on " + PlayerPokemon.getName());

                if (enemy_damage >= 25) {
                    System.out.println("A Critical Hit! " + enemy_damage + " damage.");
                } else {
                    System.out.println(enemy_damage + " damage.");
                }
                delay(500);
                PlayerPokemon.health = PlayerPokemon.getHealth() - enemy_damage;
                System.out.println(PlayerPokemon.getName() + " is left with " + PlayerPokemon.getHealth() + "HP");
                System.out.println("=============================================");
                delay(500);

                if (PlayerPokemon.health <= 0) {
                    System.out.println(PlayerPokemon.getName() + " fainted and cant continue.");
                    System.out.println(player_name + " lost the duel.");
                    System.out.println("=============================================");
                    break;
                }
                userTurn = true;
            }

            while (true) {
                System.out.println("Do you want to continue? y/n");
                String x = sc.nextLine();

                if (x.equalsIgnoreCase("y")) {
                    String streng[] = {};
                    PokemonGame.main(streng);
                } else if (x.equalsIgnoreCase("n")) {
                    System.exit(0);
                }
            }
        }
    }

    public static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
