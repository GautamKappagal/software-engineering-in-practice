# Lab notes

Both pieces of code avoid a long `if`/`else` chain by keeping each
behavior separate and choosing an implementation indirectly. In
`DiscountCodes`, the code is a key in a map whose value is the function
that calculates the discount. `apply` looks up the function and calls
it. In the notifier example, `ReceiptService` receives a `Notifier` and
calls its `send` method; the caller chooses which implementation to
pass, such as `ConsoleNotifier`, `InMemoryNotifier`, or
`SilentNotifier`.

So the main idea is not that any function or subclass can be used
arbitrarily. The alternatives must match the expected contract, and
the caller or lookup chooses one. The discount example selects a
function by code, while the notifier example selects an object by
passing it in. In both cases, adding or swapping a behavior does not
require expanding a conditional chain inside the function that applies
the discount or sends the receipt.

If `ReceiptService` created its own `ConsoleNotifier`, its caller could
no longer choose a different notifier implementation to use.

A **Factory** centralizes the choice and creation of an object, so the
callers can request one without each making that choice themselves.
An **Adapter** wraps an object with a different interface and translates
calls so it can be used where the expected interface is required.

For `SAVE_FLAT2`, I added 6 lines across 2 files: one map entry in
`DiscountCodes.java` and a test in `DiscountCodesTest.java`. I did not
need to change the existing discount logic.
