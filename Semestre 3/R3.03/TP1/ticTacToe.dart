import 'dart:io';

void main() {
  print("---Jeu du TicTacToe---");

  bool gagnant = false;
  List<List<String>> point = [[".", ".", "."],[".", ".", "."],[".", ".", "."]];
  List<int> joueur = [1, 2];
  afficherGrille(point);
  int valeur1;
  int valeur2;
  jeu:
  while(!gagnant) {
    for(int i=0; i<joueur.length; i++) {
      print("Au joueur ${joueur[i]} de jouer");
      bool caseChoisi = false;
      while(caseChoisi != true) {
        print("Choisissez une ligne : ");
        String? reponse1 = stdin.readLineSync();
        print("Choisissez une colonne : ");
        String? reponse2 = stdin.readLineSync();
        valeur1 = int.parse(reponse1!) - 1;
        valeur2 = int.parse(reponse2!) -1;
        if (valeur1 < 0 || valeur1 > 2 || valeur2 < 0 || valeur2 > 2) {
          print("Coordonnées invalides ! Entrez 1, 2 ou 3.");
          continue; 
        }
        if(point[valeur1][valeur2] != ".") print("La case est déjà rempli");
        else {
          caseChoisi = true;
          if (joueur[i] == 1) point[valeur1][valeur2] = "X";
          else point[valeur1][valeur2] = "O";
          afficherGrille(point);
          if(Var(point)) {
            gagnant = true;
            print("Bravo joueur ${joueur[i]}, tu as gagné la partie !!");
            break jeu;
          }
        }
      }
    }
  }
}

bool Var(List<List<String>> point) {
  //Vérification des lignes
  for(int i=0; i<3; i++) {
    if(point[i][0] != "." && point[i][0] == point[i][1] && point[i][1] == point[i][2]) {
      return true;
    }
  }
  //Vérification des colonnes
  for(int i=0; i<3; i++) {
    if(point[0][i] != "." && point[0][i] == point[1][i] && point[1][i] == point[2][i]) {
      return true;
    }
  }
  //Vérification des diagonales
  if(point[0][0] != "." && point[0][0] == point[1][1] && point[1][1] == point[2][2]) {
    return true;
  }
  if(point[0][2] != "." && point[0][2] == point[1][1] && point[1][1] == point[0][0]) {
    return true;
  }
  return false;
}


afficherGrille(List<List<String>> point) {
  for(int i=0; i<3; i++) {
    print("${point[i][0]} | ${point[i][1]} | ${point[i][2]} <-- Ligne ${i+1}\n");
  }
}