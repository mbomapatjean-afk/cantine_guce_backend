// lib/models/commande.dart
import 'menu.dart';
import 'user.dart';

class Commande {
  final int? id;           // null lors de la création
  final User user;
  final Menu menu;
  final DateTime dateChoix;
  final String qrCode;

  Commande({
    this.id,
    required this.user,
    required this.menu,
    required this.dateChoix,
    required this.qrCode,
  });

  Map<String, dynamic> toJson() => {  // Pour envoyer au backend (POST)
    "userId": user.id,
    "menuId": menu.id,
    "dateChoix": dateChoix.toIso8601String().split('T')[0],
    "qrCode": qrCode,
  };

  // Pour recevoir du backend (GET)
  factory Commande.fromJson(Map<String, dynamic> json) {
    return Commande(
      id: json['id'],
      user: User.fromJson(json['user']),
      menu: Menu.fromJson(json['menu']),
      dateChoix: DateTime.parse(json['dateChoix']),
      qrCode: json['qrCode'] ?? "",
    );
  }
}