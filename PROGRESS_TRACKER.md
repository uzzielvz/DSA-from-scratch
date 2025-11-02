# FAANG Interview Prep - Progress Tracker

**Goal:** FAANG Internship July-August 2026  
**Target:** 200-250 problems  
**Timeline:** ~270 days (~38 weeks)  
**Started:** October 31, 2025

---

## Current Stats

- **Total Problems Solved:** 29 / 250
- **Current Streak:** 2 days (Oct 30-31)
- **Longest Streak:** TBD
- **Average Problems/Week:** ~6-7 (projected)
- **Total Hours Invested:** ~2 hours (tracking started today)

### By Difficulty
- **Easy:** 27
- **Medium:** 2
- **Hard:** 0

### By Pattern
- **Arrays/Strings:** 12
- **Hash Tables:** 2
- **Two Pointers:** 4
- **Binary Search:** 2 ✅ (Started Oct 31)
- **Linked Lists:** 0
- **Stacks/Queues:** 1
- **Trees:** 0 🚨 CRITICAL
- **Graphs:** 0 🚨 CRITICAL
- **Recursion/Backtracking:** 0
- **Dynamic Programming:** 0 🚨 CRITICAL
- **Bit Manipulation:** 1
- **Sorting:** 3
- **Math:** 4

---

## Problem Log

### Week 1: Oct 31 - Nov 6, 2025

#### Friday, October 31, 2025
**Session Time:** ~1 hour  
**Pattern Focus:** Binary Search (NEW)

| # | Problem | Difficulty | Pattern | Time | Status | Notes |
|---|---------|------------|---------|------|--------|-------|
| 704 | Binary Search | Easy | Binary Search | ~30 min | ✅ Solved | First Binary Search problem. Bug: loop condition (left < right → left <= right). Understood why left <= right is correct. |
| 35 | Search Insert Position | Easy | Binary Search | ~12 min | ✅ Solved | Applied same template. Key insight: return left when not found. Faster than first problem (pattern recognition working). |

**Key Learnings:**
- Binary Search template: `while(left <= right)` is crucial
- When loop terminates: `left > right` (not equal)
- `left` indicates insertion position when target not found
- Mid calculation: `mid = (left + right) / 2`

**Wins:**
- Debugged loop condition independently
- Second problem solved faster (30 min → 12 min)
- Correct complexity analysis for both

**Areas to Improve:**
- Initial confusion about when loop terminates
- Need more Binary Search variations to solidify

---

#### Saturday, November 1, 2025
**Session Time:** ~20 minutes  
**Pattern Focus:** Binary Search (numeric range)

| # | Problem | Difficulty | Pattern | Time | Status | Notes |
|---|---------|------------|---------|------|--------|-------|
| 367 | Valid Perfect Square | Easy | Binary Search | ~15-20 min | ✅ Solved | Binary search on [1, num/2]. Avoided overflow using division: compare q = num/mid with mid and confirm with num % mid == 0. Will review logic fresh tomorrow. |

**Light Day:** Tired from work; kept streak with quick review and one easy problem.

---

## Pattern Mastery Status

### ✅ Comfortable (Can solve Easy in <20 min)
- Arrays (basic operations)
- Hash Tables (basic lookup/counting)
- Two Pointers (basic)

### 🔄 Learning (Started, need more practice)
- **Binary Search** - 2 problems, need 6-8 more to master

### ❌ Not Started (CRITICAL to address)
- **Trees** - 0 problems (URGENT: ~40% of FAANG interviews)
- **Graphs** - 0 problems (URGENT)
- **Dynamic Programming** - 0 problems (URGENT)
- **Linked Lists** - 0 problems
- **Recursion/Backtracking** - 0 problems

### 📊 Intermediate Understanding
- Stacks/Queues - 1 problem (need more)
- Sorting algorithms - basic understanding
- Bit Manipulation - 1 problem

---

## Weekly Velocity

| Week | Start Date | Problems | Hours | Patterns Covered | Notes |
|------|------------|----------|-------|------------------|-------|
| 1 | Oct 31 | 2 | ~1 | Binary Search (new) | Strong start, good debugging |

---

## Milestones

### 🎯 Upcoming Milestones
- [ ] 7 consecutive days of practice
- [ ] 50 total problems (21 to go)
- [ ] First Medium Binary Search problem
- [ ] Start Trees (URGENT - by Week 3)
- [ ] 10 Binary Search problems (pattern mastery)

### ✅ Completed Milestones
- [x] Started tracking progress (Oct 31, 2025)
- [x] First Binary Search problem solved
- [x] Independently debugged and fixed code

---

## Problem Repository

### Previously Solved (Before Tracking)

**Arrays (12 problems):**
- Best Time to Buy and Sell Stock (#121) - Easy
- Best Time to Buy and Sell Stock II (#122) - Medium
- Can Place Flowers (#605) - Easy
- Find Numbers with Even Number of Digits (#1295) - Easy
- Max Consecutive Ones (#485) - Easy
- Maximum Difference Between... (#3423) - Easy
- Merge Arrays Alternately (#1768) - Easy
- Merge Sorted Array (#88) - Easy
- Move Zeroes (#283) - Easy
- Partition Array Such That... (#2294) - Medium
- Remove Duplicates from Sorted Array (#26) - Easy
- Remove Element (#27) - Easy
- Squares of Sorted Array (#977) - Easy
- Transpose Matrix (#867) - Easy

**Hash Tables (2 problems):**
- Check If N and Its Double Exist (#1346) - Easy
- Contains Duplicate (#217) - Easy
- Intersection of Two Arrays II (#350) - Easy
- Two Sum (#1) - Easy
- Valid Anagram (#242) - Easy

**Two Pointers (4 problems):**
- Merge Sorted Array (#88) - Easy (also in Arrays)
- Move Zeroes (#283) - Easy (also in Arrays)
- Remove Duplicates from Sorted Array (#26) - Easy
- Remove Element (#27) - Easy
- Reverse Words in a String (#151) - Easy

**Stacks/Queues (1 problem):**
- Valid Parentheses (#20) - Easy

**Bit Manipulation (1 problem):**
- Convert a Number to Hexadecimal (#405) - Easy

**Sorting:**
- (Implied in several array problems)

**Strings:**
- Greatest Common Divisor of Strings (#1071) - Easy
- Kids With the Greatest Number of Candies (#1431) - Easy
- Product of Array Except Self (#238) - Medium
- Reverse Words in a String (#151) - Easy

---

## Critical Gaps Analysis

### 🚨 URGENT (Must address in next 2-3 weeks)
1. **Trees (0/10)** - Fundamental for FAANG
   - Start with: Easy tree traversals
   - Goal: 10-12 tree problems by Week 4
   
2. **Linked Lists (0/10)** - Common in interviews
   - Fast/Slow pointer pattern
   - Goal: 8-10 problems by Week 4

3. **Binary Search Depth** - Only 2 problems
   - Need 6-8 more for pattern mastery
   - Goal: Complete by Week 2

### ⚠️ IMPORTANT (Address in 4-6 weeks)
1. **Graphs (0/10)** - Critical for Amazon/Meta/Google
2. **Dynamic Programming (0/10)** - Required for Medium/Hard
3. **Recursion/Backtracking (0/10)** - Foundation for many patterns

### 📊 Monitor & Improve
1. Medium/Hard ratio - Currently 2/27 (7.4%)
   - Target: 40% Medium by Week 12
2. Speed on Medium problems
   - Track and improve over time

---

## Next Session Plan

**Date:** Saturday, November 1, 2025  
**Available Time:** 2 hours  
**Focus:** Binary Search (continue pattern mastery)

**Goals:**
- [ ] Solve 2-3 more Binary Search problems
- [ ] Progress: Easy → Medium transition
- [ ] Document all solutions

**Suggested Problems:**
1. #278 - First Bad Version (Easy) - Different context
2. #69 - Sqrt(x) (Easy) - Numeric binary search
3. #153 - Find Minimum in Rotated Sorted Array (Medium) - Level up

---

## Coach Notes

### Strengths Observed:
- Mathematical thinking helps with algorithm analysis
- Fast learner - second problem solved in 12 min vs 30 min
- Good at debugging independently
- Analyzes complexity correctly
- Asks good clarifying questions

### Areas for Development:
- Consistency (mentioned as personal challenge)
- Need to tackle uncomfortable patterns (Trees, Graphs)
- Transition to Medium difficulty
- Speed on first attempt (will improve with practice)

### Coaching Strategy:
- Build confidence with Binary Search mastery (1-2 weeks)
- Introduce Trees by Week 3 (cannot delay)
- Gradually increase Medium problems
- Maintain accountability for daily practice
- Celebrate small wins to maintain motivation

---

**Last Updated:** October 31, 2025, 11:59 PM  
**Next Update:** After next practice session

