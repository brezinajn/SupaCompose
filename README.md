# supabase-kt

A Kotlin Multiplatform Client for Supabase.
Supported targets:
- JVM
- Android
- JS (Browser)
- _IOS ([PR open](https://github.com/supabase-community/supabase-kt/pull/53), help appreciated)_

Newest stable version: ![stable](https://img.shields.io/github/release/supabase-community/supabase-kt?label=stable)

Newest experimental version: ![experimental](https://img.shields.io/maven-central/v/io.github.jan-tennert.supabase/supabase-kt?label=experimental)

Dokka documentation for the latest version: [stable](https://supabase-community.github.io/supabase-kt/)

# Installation

```kotlin
dependencies {
    implementation("io.github.jan-tennert.supabase:[module e.g. functions-kt or gotrue-kt]:VERSION")

    //add ktor client engine (if you don't already have one, see https://ktor.io/docs/http-client-engines.html for all engines)
    //e.g. the CIO engine
    implementation("io.ktor:ktor-client-cio:KTOR_VERSION")
}
```

If you use multiple modules, you can use the bom dependency to get the correct versions for all modules:

```kotlin
implementation(platform("io.github.jan-tennert.supabase:bom:VERSION"))
implementation("io.github.jan-tennert.supabase:[module e.g. functions-kt or gotrue-kt]")
```

In Multiplatform projects (before Kotlin 1.8.0):
```kotlin
implementation(project.dependencies.platform("io.github.jan-tennert.supabase:bom:VERSION"))
implementation("io.github.jan-tennert.supabase:[module e.g. functions-kt or gotrue-kt]")
```

# [Getting started](https://github.com/supabase-community/supabase-kt/wiki/Getting-Started)

# Main Modules

#### [Authentication (GoTrue)](/GoTrue)

#### [Database/Postgrest](/Postgrest)

#### [Storage](/Storage)

#### [Realtime](/Realtime)

#### [Functions (Edge Functions)](/Functions)

### Plugins

#### [Apollo GraphQL integration](/plugins/ApolloGraphQL)

# Credits

- Postgres Syntax inspired by https://github.com/supabase-community/postgrest-kt
- Plugin system inspired by ktor
