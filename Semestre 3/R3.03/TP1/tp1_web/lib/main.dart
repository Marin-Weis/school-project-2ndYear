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
    final AudioPlayer player = AudioPlayer();
    return Scaffold(
      appBar: AppBar(title: const Text("TP1-Web")),
      body: Center(
        child: SingleChildScrollView(
          child: Column(
            children: [
              Text(
                "Jouer de la batterie avec Flutter !!",
                style: const TextStyle(fontSize: 24),
              ),
              const SizedBox(height : 40),
              InkWell(
                onTap : () {
                  player.play(AssetSource('sons/kick.mp3'));
                },
                child: Image.asset(
                  'assets/images/kick.png',
                  width: 200,
                )
              ),
              const SizedBox(height : 40),
              InkWell(
                onTap : () {
                  player.play(AssetSource('sons/caisse_claire.wav'));
                },
                child: Image.asset(
                  'assets/images/caisse_claire.png',
                  width: 200,
                )
              ),
              const SizedBox(height : 40),
              InkWell(
                onTap : () {
                  player.play(AssetSource('sons/charleston.wav'));
                },
                child: Image.asset(
                  'assets/images/charleston.png',
                  width: 200,
                )
              ),
              const SizedBox(height : 40),
              InkWell(
                onTap : () {
                  player.play(AssetSource('sons/ride.wav'));
                },
                child: Image.asset(
                  'assets/images/ride.webp',
                  width: 200,
                )
              )
            ],
          ),
        ),
      ),
    );
  }
}
