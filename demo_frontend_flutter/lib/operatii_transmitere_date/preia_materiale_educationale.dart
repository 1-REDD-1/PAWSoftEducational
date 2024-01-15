import 'package:demo_frontend_flutter/operatii_transmitere_date/realizeaza_cerere_get.dart';
import 'package:http/http.dart';


Future<List<dynamic>> preiaToateMaterialele () {
    return realizeazaCerereGet("/materialcurs/toate");
}