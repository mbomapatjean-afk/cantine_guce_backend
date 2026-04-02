import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:cantine_app/models/commande.dart';

import '../models/menu.dart';
import '../models/user.dart';

class ApiService {
  final String baseUrl = "http://localhost:8981/api";

  Future<List<Commande>> getCommandes() async {
    final response = await http.get(Uri.parse("$baseUrl/commandes"));

    if (response.statusCode == 200) {
      final List data = jsonDecode(response.body);
      return data.map((e) => Commande.fromJson(e)).toList();
    } else {
      throw Exception("Erreur API");
    }
  }

  Future<void> createCommande(Commande commande) async {
    final response = await http.post(
      Uri.parse("$baseUrl/commandes"),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(commande.toJson()),
    );

    if (response.statusCode != 200 && response.statusCode != 201) {
      print("Erreur backend: ${response.body}");
      throw Exception("Erreur création");
    }
  }

  Future<User> getUser(int id) async {
    final response = await http.get(Uri.parse('$baseUrl/users/$id'));
    print("GET USER STATUS: ${response.statusCode}");
    print("BODY: ${response.body}");
    if (response.statusCode == 200) {
      return User.fromJson(jsonDecode(response.body));
    } else {
      throw Exception("Erreur récupération user");
    }
  }

  Future<List<Menu>> getMenus() async {
    final response = await http.get(Uri.parse('$baseUrl/menus'));
    print("GET MENUS STATUS: ${response.statusCode}");
    print("BODY: ${response.body}");
    if (response.statusCode == 200) {
      final List data = jsonDecode(response.body);
      return data.map((e) => Menu.fromJson(e)).toList();
    } else {
      throw Exception("Erreur récupération menus");
    }
  }
}