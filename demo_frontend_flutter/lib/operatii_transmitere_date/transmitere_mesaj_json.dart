import 'dart:convert';

import 'package:http/http.dart';

Future<Response> trimiteMesaj (Map<String, dynamic> mesaj) async {
    Map<String, dynamic> a = <String, dynamic>{
        "message": "a"
    };

    String corp = jsonEncode(mesaj);

    Response response = await post(
        Uri(host: "localhost", port: 7890),
        headers: {"Content-Type": "application/json"},
        body: corp
    );

    print("${response.statusCode}");
    print("${response.body}");

    return response;
}