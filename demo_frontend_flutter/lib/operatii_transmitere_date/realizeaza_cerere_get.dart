import 'dart:convert';

import 'package:http/http.dart';

Future<List<dynamic>> realizeazaCerereGet (String endpoint) async {
    String username = 'admin';
    String password = 'password';
    String basicAuth = 'Basic ${base64Encode(utf8.encode('$username:$password'))}';

    Response raspuns = await get(
        Uri(host: "localhost", port: 8080, path: endpoint, scheme: "http"),
        headers: {
            "Content-Type": "application/json",
            "Authorization": basicAuth
        },
    );

    print("${raspuns.statusCode}");
    print("${raspuns.body}");

    return jsonDecode(raspuns.body);
}