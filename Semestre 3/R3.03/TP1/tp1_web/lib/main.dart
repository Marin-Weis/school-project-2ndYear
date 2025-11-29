import 'package:flutter/material.dart';
import 'package:audioplayers/audioplayers.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'TP1-Web',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("TP1-Web")),
      body: Center(
        child: Container(
          child: Column(
            children: [
              Text(
                "Jouer de la batterie avec Flutter !!",
                style: const TextStyle(fontSize: 24),
              ),
              const SizedBox(height: 40),
              //Ajout d'un bouton pour jouer un son de batterie
              ElevatedButton(
                onPressed: () {
                  final AudioPlayer player = AudioPlayer();
                  player.play(AssetSource('sons/Son1.wav'));
                },
                child: const Text("Batterie 1"),
              ),
              const SizedBox(height: 40),
              ElevatedButton(
                onPressed: () {
                  final AudioPlayer player = AudioPlayer();
                  player.play(AssetSource('sons/Son2.wav'));
                },
                child: const Text("Batterie 2"),
              ),
              const SizedBox(height: 40),
              ElevatedButton(
                onPressed: () {
                  final AudioPlayer player = AudioPlayer();
                  player.play(AssetSource('sons/Son3.wav'));
                },
                child: const Text("Batterie 3"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
