import 'package:flutter/material.dart';
import 'cupertino_page.dart';


void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
          primarySwatch: Colors.blue,
        ),
        home: HelloPage('헬로 월드'));
  }
}

//상태를 가지는 위젯
class HelloPage extends StatefulWidget {
  late String title;

  HelloPage(this.title, {Key? key}) : super(key: key);

  @override
  State<HelloPage> createState() => _HelloPageState();
}

//여기서 그린다.
class _HelloPageState extends State<HelloPage> {
  String _message = 'Hello World';
  int _counter = 0;

  @override
  Widget build(BuildContext context) {
    //widget은 위 HelloPate

    return Scaffold(
        floatingActionButton: FloatingActionButton(
            child: Icon(Icons.add), onPressed: _changeMessage),
        appBar: AppBar(title: Text(widget.title)),
        body: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              //여러개는 children
              children: <Widget>[
                Text(_message, style: TextStyle(fontSize: 30)),
                Text('$_counter', style: TextStyle(fontSize: 30)),
                RaisedButton(
                  child: Text('화면이동'),
                  onPressed: (){
                    Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => CupertinoPage())
                    );
                  },
                )
              ],
            )
        ));
  }

  void _changeMessage() {
    //안에서 호출하면 ui 변경하겠다.
    setState(() {
      _message = '헬로 월드!!!';
      _counter ++;
    });
  }
}
