import 'dart:html';

void main() {
  querySelector('#output').append(Counter().build());
}

class Counter {
  int value = 0;

  Element build() {
    final out = DivElement();

    update() => out.text = "The current count is $value";
    update();
    handler(bool increment) {
      if (increment)
        value++;
      else
        value--;
      update();
    }

    final up = ButtonElement()
      ..text = 'Increment'
      ..onClick.listen((e) => handler(true));
    final down = ButtonElement()
      ..text = 'Decrement'
      ..onClick.listen((e) => handler(false));

    return DivElement()..append(out)..append(up)..append(down);
  }
}
