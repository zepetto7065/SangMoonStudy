import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';

class HomePage extends StatelessWidget {
  final User user;

  HomePage(this.user);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        title: Text(
          'Instagram Clon',
          style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold),
        ),
      ),
      body: _buildBody(),
    );
  }

  Widget _buildBody() {
    return Padding(
      padding: EdgeInsets.all(8.0),
      child: SafeArea(
        //ios 노치로 인해
        child: SingleChildScrollView(
          child: Center(
            child: Column(
              children: <Widget>[
                Text(
                  'Instagram에 오신 것을 환영합니다.',
                  style: TextStyle(fontSize: 24.0),
                ),
                Padding(padding: EdgeInsets.all(8.0)),
                Text(
                  '사진과 동영상을 보려면 팔로우하세요.',
                ),
                Padding(padding: EdgeInsets.all(8.0)),
                SizedBox(
                  width: 240.0,
                  child: Card(
                    elevation: 4.0,
                    child: Padding(
                      padding: const EdgeInsets.all(4.0),
                      child: Column(
                        children: <Widget>[
                          Padding(padding: EdgeInsets.all(4.0)),
                          SizedBox(
                            width: 80.0,
                            height: 80.0,
                            child: CircleAvatar(
                              backgroundImage: NetworkImage(
                                user.photoURL
                              ),
                            ),
                          ),
                          Padding(padding: EdgeInsets.all(8.0)),
                          Text(
                            user.email,
                            style: TextStyle(fontWeight: FontWeight.bold),
                          ),
                          Padding(padding: EdgeInsets.all(8.0)),
                          Text(user.displayName),
                          Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: <Widget>[
                              SizedBox(
                                width: 70.0,
                                height: 70.0,
                                child: Image.network(
                                    'https://www.lego.com/cdn/cs/set/assets/blt9daed402e8b1f001/CP_IronMan_Sidekick-Tallb388732cc325ae4da0f803782153ff238247b7123287b15319250fb5bf6502bf.jpg?fit=crop&format=jpg&quality=80&width=800&height=600&dpr=1', fit:BoxFit.cover),
                              ),
                              Padding(padding: EdgeInsets.all(1.0)),
                              SizedBox(
                                width: 70.0,
                                height: 70.0,
                                child: Image.network(
                                    'https://www.lego.com/cdn/cs/set/assets/blt9daed402e8b1f001/CP_IronMan_Sidekick-Tallb388732cc325ae4da0f803782153ff238247b7123287b15319250fb5bf6502bf.jpg?fit=crop&format=jpg&quality=80&width=800&height=600&dpr=1' , fit:BoxFit.cover),
                              ),
                              Padding(padding: EdgeInsets.all(1.0)),
                              SizedBox(
                                width: 70.0,
                                height: 70.0,
                                child: Image.network(
                                    'https://www.lego.com/cdn/cs/set/assets/blt9daed402e8b1f001/CP_IronMan_Sidekick-Tallb388732cc325ae4da0f803782153ff238247b7123287b15319250fb5bf6502bf.jpg?fit=crop&format=jpg&quality=80&width=800&height=600&dpr=1' , fit:BoxFit.cover),
                              ),
                            ],
                          ),
                          Padding(padding: EdgeInsets.all(4.0)),
                          Text('Facebook 친구'),
                          Padding(padding: EdgeInsets.all(4.0)),
                          ElevatedButton(
                            child: Text('팔로우'),
                            onPressed: () {},
                          ),
                          Padding(padding: EdgeInsets.all(4.0)),
                        ],
                      ),
                    ),
                  ),
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
