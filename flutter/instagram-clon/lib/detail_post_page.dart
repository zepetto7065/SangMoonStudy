import 'package:flutter/material.dart';
import 'package:instagram_clon/search_page.dart';

class DetailPostPage extends StatelessWidget {
  final Person person;

  DetailPostPage(this.person);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('둘러보기')
      ),
      body: _buildBody(),
    );
  }

  Widget _buildBody() {
    return SafeArea(
      child: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Padding(
                padding:EdgeInsets.all(8.0),
              child: Row(
                children: [
                  Text( person.name)
                ],
              ),
            ),
             Image.network('https://i.stack.imgur.com/azeVA.jpg')
          ]
        ),
      ),
    );
  }


}
