import 'package:flutter/material.dart';
import 'package:cantine_app/screens/commande_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Cantine GUCE',
      theme: ThemeData(
        primarySwatch: Colors.orange,
      ),
      home: CommandeScreen(),
    );
  }
}