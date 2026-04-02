class Provider {
  final int id;
  final String raisonSociale;
  final String numeroCompteContribuable;
  final String email;
  final String phone;

  Provider({
    required this.id,
    required this.raisonSociale,
    required this.numeroCompteContribuable,
    required this.email,
    required this.phone,
  });

  factory Provider.fromJson(Map<String, dynamic> json) {
    return Provider(
      id: (json['id'] as num?)?.toInt() ?? 0,
      raisonSociale: json['raisonSociale'] as String? ?? '',
      numeroCompteContribuable:
      json['numeroCompteContribuable'] as String? ?? '',
      email: json['email'] as String? ?? '',
      phone: json['phone'] as String? ?? '',
    );
  }

  Map<String, dynamic> toJson() => {
    "id": id,
    "raisonSociale": raisonSociale,
    "numeroCompteContribuable": numeroCompteContribuable,
    "email": email,
    "phone": phone,
  };
}