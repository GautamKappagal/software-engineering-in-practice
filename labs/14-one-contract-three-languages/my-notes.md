# Lab notes

1. In Java, `SilentNotifier` satisfies `Notifier` because its class
   declaration says `implements Notifier`. The Java compiler checks that
   declaration and requires the class to provide the interface's `send`
   method.

2. Go catches a misspelled method name earliest in the Step 4 examples.
   The compiler reports that the type is missing the required `Send`
   method when it is passed where a `Notifier` is expected, before the
   program runs. Python only raises an `AttributeError` when the faulty
   code path calls `.send(...)`.

3. The failure shows up differently in each language:
   - **Java:** If a class has `send` but omits `implements Notifier`, the
     compiler rejects passing it to a method that expects `Notifier`,
     reporting that the class cannot be converted to `Notifier`.
   - **Go:** If a type has `Sand` instead of `Send`, the compiler rejects
     passing it as a `Notifier` and reports that it is missing `Send`.
   - **Python:** If an object has `sand` instead of `send`, there is no
     compile-time contract check. An `AttributeError` appears only when
     execution reaches the call to `.send(...)`; if that path never runs,
     the mistake is not reported.
