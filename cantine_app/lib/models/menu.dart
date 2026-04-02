import 'provider.dart';

class Menu {
  final int id;
  final String nom;
  final String? description;
  final String? image;
  final String? dateDebutSemaine;
  final Provider? provider;

  Menu({
    required this.id,
    required this.nom,
    this.description,
    this.image,
    this.dateDebutSemaine,
    this.provider,
  });

  factory Menu.fromJson(Map<String, dynamic> json) {
    return Menu(
      id: (json['id'] as num?)?.toInt() ?? 0,
      nom: json['nom'] as String? ?? '',
      description: json['description'] as String?,
      image: json['image'] as String?,
      dateDebutSemaine: json['dateDebutSemaine'] as String?,
      provider: json['provider'] != null
          ? Provider.fromJson(json['provider']) // ⚠️ JSON inchangé
          : null,
    );
  }
}