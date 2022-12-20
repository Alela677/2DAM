import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

enum SampleItem { itemOne, itemTwo, itemThree }

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        body: GridView.count(
          crossAxisCount: 2,
          crossAxisSpacing: 5,
          mainAxisSpacing: 5,
          padding: const EdgeInsets.all(15),
          children: [
            Card(
              color: Colors.blue,
              child: FloatingActionButton(
                  backgroundColor: Colors.white,
                  child: const Icon(
                    Icons.access_alarm,
                    size: 100,
                    color: Colors.blue,
                  ),
                  onPressed: () {}),
            ),
            Card(
              color: Colors.blue,
              child: TextButton(
                child: const Text(
                  'Texto boton',
                  style: TextStyle(color: Colors.white, fontSize: 30),
                ),
                onPressed: () {},
              ),
            ),
            Card(
              color: Colors.blue,
              child: SizedBox(
                child: ElevatedButton(
                    onPressed: () {},
                    child: const Text(
                      'Elevated Button',
                      style: TextStyle(fontSize: 50),
                    )),
              ),
            ),
            Card(
              color: Colors.blue,
              child: IconButton(
                  onPressed: () {},
                  icon: const Icon(
                    Icons.heart_broken,
                    color: Colors.white,
                    size: 60,
                  )),
            ),
            Card(
              color: Colors.blue,
              child: PopupMenuButton(
                icon: const Icon(
                  Icons.more_vert,
                  color: Colors.white,
                  size: 70,
                ),
                itemBuilder: ((context) => [
                      const PopupMenuItem(child: Text('Menu 1')),
                      const PopupMenuItem(child: Text('Menu 2')),
                      const PopupMenuItem(child: Text('Menu 3')),
                    ]),
              ),
            ),
            Card(
                color: Colors.blue,
                child: OutlinedButton(
                    onPressed: () {},
                    child: const Text(
                      'Outline Button',
                      style: TextStyle(color: Colors.white, fontSize: 50),
                    ))),
          ],
        ),
      ),
    );
  }
}

const tetxoFloatBoton = SnackBar(
  content: Text('Pulsaste el boton flotante'),
);
