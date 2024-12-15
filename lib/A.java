import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:audioplayers/audioplayers.dart';

final player = AudioPlayer()..setReleaseMode(ReleaseMode.loop);

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Autobiography App',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(primarySwatch: Colors.green),
      home: HomePage(),
    );
  }
}

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final tabs = [
    Screen1(),
    Screen2(),
    Screen3(),
    Screen4(),
  ];

  int previousIndex = 0;
  int currentIndex = 0;

  @override
  Widget build(BuildContext context) {
    if (currentIndex == 0) player.play(AssetSource("1.mp3"));
    return Scaffold(
      appBar: AppBar(
        title: Text('我的自傳'),
        centerTitle: true,
      ),
      body: tabs[currentIndex],
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        backgroundColor: Colors.blue,
        selectedItemColor: Colors.white,
        selectedFontSize: 18,
        unselectedFontSize: 14,
        iconSize: 30,
        currentIndex: currentIndex,
        items: [
          BottomNavigationBarItem(
            icon: currentIndex == 0
                ? Image.asset('assets/f1.jpg', width: 40, height: 40)
                : Image.asset('assets/f1.jpg', width: 30, height: 30),
            label: '自我介紹',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.school),
            label: '學習歷程',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.scale_outlined),
            label: '學習計畫',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.engineering),
            label: '專業方向',
          ),
        ],
        onTap: (index) {
          setState(() {
            previousIndex = currentIndex;
            currentIndex = index;
            if (index == 0) {
              if (previousIndex == currentIndex) player.resume();
              player.stop();
              player.play(AssetSource("1.mp3"));
            }
            if (index == 1) {
              if (previousIndex == currentIndex) player.resume();
              player.stop();
              player.play(AssetSource("2.mp3"));
            }
            if (index == 2) {
              if (previousIndex == currentIndex) player.resume();
              player.stop();
              player.play(AssetSource("3.mp3"));
            }
            if (index == 3) {
              if (previousIndex == currentIndex) player.resume();
              player.stop();
              player.play(AssetSource("4.mp3"));
            }
          });
        },
      ),
    );
  }
}

class Screen1 extends StatelessWidget {
  Screen1({super.key});

  final String biography =
      'I was born in Binjai, Indonesia, on May 24, 2005. I am 19 years old. '
      'My hobbies are basketball, soccer, editing, and videography. '
      'Currently, I am studying Computer Science at the National Kaohsiung University of Science and Technology. '
      'I also work part-time at the Marriott Kaohsiung Hotel restaurant to support my tuition fees and help my parents financially. '
      'In the future, I aspire to open a restaurant in Indonesia with excellent management using technology such as a dedicated website and app.';

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        children: [
          Padding(
            padding: EdgeInsets.fromLTRB(20, 30, 20, 20),
            child: Text(
              'Who Am I',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
          ),
          Container(
            padding: EdgeInsets.all(20),
            margin: EdgeInsets.fromLTRB(30, 0, 30, 50),
            decoration: BoxDecoration(
              border: Border.all(color: Colors.black, width: 3),
              borderRadius: BorderRadius.circular(10),
              boxShadow: [
                BoxShadow(color: Colors.amberAccent, offset: Offset(6, 6)),
              ],
            ),
            child: Text(
              biography,
              style: TextStyle(fontSize: 20),
            ),
          ),
          SizedBox(height: 15),
          Container(
            color: Colors.redAccent,
            child: Image.asset('assets/f1.jpg'),
            height: 200,
            width: 200,
          ),
          SizedBox(height: 30),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Container(
                width: 150,
                height: 150,
                decoration: BoxDecoration(
                  border: Border.all(
                      color: Colors.purple,
                      width: 2,
                      style: BorderStyle.solid),
                  borderRadius: BorderRadius.circular(30),
                  image: DecorationImage(
                      image: AssetImage('assets/f1.jpg'), fit: BoxFit.cover),
                ),
              ),
              SizedBox(width: 10),
              Container(
                width: 150,
                height: 150,
                decoration: BoxDecoration(
                  border: Border.all(
                      color: Colors.purple,
                      width: 2,
                      style: BorderStyle.solid),
                  borderRadius: BorderRadius.circular(30),
                  image: DecorationImage(
                      image: AssetImage('assets/f1.jpg'), fit: BoxFit.cover),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}

class Screen2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text('學習歷程'),
    );
  }
}

class Screen3 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text('學習計畫'),
    );
  }
}

class Screen4 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text('專業方向'),
    );
  }
}
