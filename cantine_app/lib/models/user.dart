class User {
  final int id;
  final String nom;
  final String? emailGuce;
  final String? numeroBadge;
  final String? password;
  final String? role;

  User({
    required this.id,
    required this.nom,
    this.emailGuce,
    this.numeroBadge,
    this.password,
    this.role,
  });

  factory User.fromJson(Map<String, dynamic> json) {
    return User(
      id: (json['id'] as num?)?.toInt() ?? 0,
      nom: json['nom'] as String? ?? '',
      emailGuce: json['emailGuce'] as String?,
      numeroBadge: json['numeroBadge'] as String?,
      password: json['password'] as String?,
      role: json['role'] as String?,
    );
  }


  Map<String, dynamic> toJson() => {
    "id": id,
    "nom": nom,
    "emailGuce": emailGuce,
    "numeroBadge": numeroBadge,
    "password": password,
    "role": role,
  };
}