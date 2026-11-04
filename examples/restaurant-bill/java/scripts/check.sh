#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
export PMD_JAVA_DISABLE_AUX_CLASSPATH_WARNINGS=true

echo "== spotless (formatter) =="
./gradlew spotlessCheck --console=plain

echo "== pmd (static analysis) =="
./gradlew pmdMain --console=plain

echo "== tests =="
./gradlew test --console=plain
