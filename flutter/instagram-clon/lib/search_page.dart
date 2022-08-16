
import 'package:flutter/material.dart';
import 'package:instagram_clon/create_page.dart';
import 'package:instagram_clon/detail_post_page.dart';

class SearchPage extends StatefulWidget {
  @override
  State<SearchPage> createState() => _SearchPageState();
}

class _SearchPageState extends State<SearchPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: _buildBody(),
      floatingActionButton: FloatingActionButton(
        onPressed: (){
          Navigator.push(context,
              MaterialPageRoute(builder: (context)=>CreatePage()));
        },
        child: Icon(Icons.create),
        backgroundColor: Colors.blue,
      ),
    );
  }

  Widget _buildBody() {

    var items = [
       Person("유상문", 31, "www.naver.com"),
       Person("유상문2", 32, "www.naver.com"),
       Person("유상문3", 33, "www.naver.com")
    ];

    return GridView.builder(
      gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
          crossAxisCount: 3,
          childAspectRatio: 1.0,
          mainAxisSpacing: 1.0,
          crossAxisSpacing: 1.0),
      itemCount: items.length,
      itemBuilder:(context, index){
        return _buildListItem(context,items[index]);
      }
    );
  }

  Widget _buildListItem(context, document) {
    return 
      InkWell(
        onTap: (){
          Navigator.push(context, MaterialPageRoute(builder: (context){
            return DetailPostPage(document) ;
          }));
        },
          child: Image.network('https://www.lego.com/cdn/cs/set/assets/blt9daed402e8b1f001/CP_IronMan_Sidekick-Tallb388732cc325ae4da0f803782153ff238247b7123287b15319250fb5bf6502bf.jpg?fit=crop&format=jpg&quality=80&width=800&height=600&dpr=1', fit: BoxFit.cover));
  }
}

class Person{
  String name;
  int age;
  String photoUrl;

  Person(this.name, this.age, this.photoUrl);
}
