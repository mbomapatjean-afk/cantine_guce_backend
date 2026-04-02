import 'package:flutter/material.dart';
import '../models/commande.dart';

class CommandeTile extends StatelessWidget {
  final Commande commande;

  const CommandeTile({super.key, required this.commande});

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: EdgeInsets.symmetric(horizontal: 12, vertical: 6),
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(12),
      ),
      child: ListTile(
        leading: CircleAvatar(
          child: Text(commande.id.toString()),
        ),
        title: Text("Commande #${commande.id}"),
        subtitle: Text("QR: ${commande.qrCode}"),
      ),
    );
  }
}