import 'package:flutter/material.dart';

class PaginaPrincipala extends StatelessWidget {
    @override
    Widget build (BuildContext context) {
        return Scaffold (
            body: ListView (
                scrollDirection: Axis.vertical,
                children: [
                    Center (
                        child: Text (
                            "Soft educațional (DEMO)", style: TextStyle(
                                fontSize: 32
                            )
                        ),
                    ),

                    Padding(padding: EdgeInsets.only(bottom: 32)),

                    
                    Column (
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                            TextFormField (
                                decoration: InputDecoration (
                                    label: Text("Nume de utilizator")
                                ),
                            ),

                            TextFormField (
                                decoration: InputDecoration (
                                    label: Text("Parola")
                                ),
                            ),

                            Padding (padding: EdgeInsets.only(bottom: 32)),

                            Row (
                                crossAxisAlignment: CrossAxisAlignment.center,
                                mainAxisAlignment: MainAxisAlignment.center,
                                children: [
                                    ElevatedButton (
                                        child: Text (
                                            "Autentificare",
                                            style: TextStyle (
                                                fontSize: 18
                                            ),
                                        ),
                                        onPressed: () {

                                        },
                                    ),

                                    Padding (padding: EdgeInsets.only(left: 24)),

                                    ElevatedButton (
                                        child: Text (
                                            "Înregistrare",
                                            style: TextStyle (
                                                fontSize: 18
                                            ),
                                        ),
                                        onPressed: () {
                                        },
                                    )
                                ],
                            ),
                        ],
                    )
                ]
            )
        );
    }
}