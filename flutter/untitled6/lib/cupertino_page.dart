import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';

class CupertinoPage extends StatefulWidget {

  @override
  State createState() => _CupertinoPageState();
}

class _CupertinoPageState extends State<CupertinoPage> {
  bool _switch = true;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: CupertinoNavigationBar(
          middle: Text('쿠퍼티노 UI')
        ),
        body: Column(
          children: <Widget>[
            CupertinoButton(
              child: Text('쿠퍼티노 버튼'), onPressed: getPress(),
            ),
            CupertinoSwitch(
                value: _switch, onChanged: (bool value){
                  setState((){
                    _switch = value;
                  });
                }
            ),
          ],
        )
    );
  }

  getPress() {}
}