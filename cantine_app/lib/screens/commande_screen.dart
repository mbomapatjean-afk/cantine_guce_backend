import 'package:flutter/material.dart';
import 'package:cantine_app/models/commande.dart';
import 'package:cantine_app/services/api_service.dart';
import 'package:cantine_app/widgets/commande_tile.dart';

import '../models/menu.dart';
import '../models/user.dart';

class CommandeScreen extends StatefulWidget {
  @override
  _CommandeScreenState createState() => _CommandeScreenState();
}
class _CommandeScreenState extends State<CommandeScreen> {
  final ApiService api = ApiService();
  List<Commande> commandes = [];
  bool isLoading = true;

  User? currentUser;
  Menu? selectedMenu;

  @override
  void initState() {
    super.initState();
    loadCurrentUser();
    loadCommandes();
    loadMenus();
  }

  Future<void> loadCurrentUser() async {
    // Exemple : récupérer user 1 depuis backend
    try {
      final user = await api.getUser(1);
      setState(() {
        currentUser = user;
      });
    } catch (e) {
      print("Erreur loadCurrentUser: $e");
    }
  }

  Future<void> loadCommandes() async {
    try {
      final data = await api.getCommandes();
      setState(() {
        commandes = data;
        isLoading = false;
      });
    } catch (e) {
      print(e);
    }
  }
  Future<void> loadMenus() async {
    try {
      final menus = await api.getMenus();
      setState(() {
        if (menus.isNotEmpty) selectedMenu = menus.first; // par défaut premier menu
      });
    } catch (e) {
      print("Erreur loadMenus: $e");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Cantine GUCE"),
        centerTitle: true,
      ),
      body: isLoading
          ? Center(child: CircularProgressIndicator())
          : RefreshIndicator(
        onRefresh: loadCommandes,
        child: ListView.builder(
          itemCount: commandes.length,
          itemBuilder: (context, index) {
            return CommandeTile(commande: commandes[index]);
          },
        ),
      ),floatingActionButton: FloatingActionButton(
      onPressed: () async {
        if (currentUser == null || selectedMenu == null) {
          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(content: Text("Utilisateur ou menu non sélectionné")),
          );
          return;
        }

        try {
          final cmd = Commande(
            user: currentUser!,
            menu: selectedMenu!,
            dateChoix: DateTime.now(),
            qrCode: "QR-${DateTime.now().millisecondsSinceEpoch}",
          );

          await api.createCommande(cmd);

          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(content: Text("Commande créée ✅")),
          );

        } catch (e) {
          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(content: Text("Erreur ❌")),
          );
        }
      },
      child: Icon(Icons.add),
    ),
    );
  }
}