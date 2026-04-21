# Changelog

All notable changes to this project will be documented in this file.
Format: [Keep a Changelog](https://keepachangelog.com/en/1.1.0/). Versioning: [SemVer](https://semver.org/).

## [Unreleased]

## [0.3.0] — 2026-04-21

### Added
- **Optional feedback prompt:** After ~14 days of real use (20+ throttled usage ticks), a one-time balloon quietly asks if you'd like to rate the plugin on Marketplace. Includes a "Don't show again" action and a 14-day "Remind me later" snooze.
- **Pairs well with CSS Variables Assistant:** Marketplace description and README now link to [CSS Variables Assistant](https://plugins.jetbrains.com/plugin/27392-css-variables-assistant) — a sibling plugin by the same author adding autocomplete, hover docs, and `@import` resolution for CSS custom properties.

## [0.2.0] — 2026-04-16

### Added
- Hint placement preference: **End of line** (aggregated after `;`) or **Inline** (next to each value).
- Settings panel at *Settings → Editor → Inlay Hints → PxPeek*.

### Changed
- Default placement is now **End of line** for cleaner stylesheet readability.

## [0.1.0] — 2026-04-15

### Added
- First release.
- Inline pixel-equivalent inlay hints for 18 relative CSS units.
- Support for CSS, SCSS, SASS, and LESS file types.
- Per-language toggle via *Settings → Editor → Inlay Hints → Values → Pixel equivalents*.

[Unreleased]: https://github.com/Stianlars1/pxpeek/compare/v0.3.0...HEAD
[0.3.0]: https://github.com/Stianlars1/pxpeek/compare/v0.2.0...v0.3.0
[0.2.0]: https://github.com/Stianlars1/pxpeek/compare/v0.1.0...v0.2.0
[0.1.0]: https://github.com/Stianlars1/pxpeek/releases/tag/v0.1.0
