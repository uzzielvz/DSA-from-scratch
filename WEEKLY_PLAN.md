# Weekly Plan - FAANG Prep

**Current Week:** Week 1 (Oct 31 - Nov 6, 2025)  
**Current Phase:** Phase 1 - Fundamentals  
**Focus Pattern:** Binary Search

---

## Week 1: October 31 - November 6, 2025

### 🎯 Weekly Goals

**Primary Objective:** Master Binary Search pattern (8-10 problems)

**Specific Targets:**
- [ ] Complete 8-10 Binary Search problems
- [ ] Mix: 6-7 Easy, 2-3 Medium
- [ ] Reduce avg time on Easy to <15 min
- [ ] Practice at least 6 out of 7 days
- [ ] Document all solutions in repo

**Pattern Focus:** Binary Search
- Classic binary search
- Search insert position
- First/Last occurrence
- Search in rotated array
- Numeric binary search (sqrt, etc)

---

### Daily Breakdown

#### ✅ Friday, Oct 31 (COMPLETED)
**Time:** 1 hour  
**Status:** ✅ Completed

- [x] Problem #704 - Binary Search (Easy) - 30 min
- [x] Problem #35 - Search Insert Position (Easy) - 12 min
- [x] Set up tracking system

**Result:** Strong start, 2/2 solved, good debugging

---

#### Saturday, Nov 1 (COMPLETED - LIGHT DAY)
**Time:** ~20 minutes  
**Focus:** Binary Search (numeric)

**Done:**
- [x] #367 - Valid Perfect Square (Easy)

**Notes:** Día pesado de trabajo. Se mantuvo el streak con review y un problema easy. Mediums se pasan a mañana.

---

#### Sunday, Nov 2 (PLANNED)
**Time:** 2 hours  
**Focus:** Binary Search Medium problems

**Target Problems:**
1. [ ] #33 - Search in Rotated Sorted Array (Medium)
   - Classic rotated array problem
   - Common in interviews

2. [ ] #34 - Find First and Last Position (Medium)
   - Binary search variation
   - Finding range instead of single element

3. [ ] Review + Consolidate (incluye repasar #367 brevemente)
   - Review all Binary Search problems solved
   - Identify common patterns
   - Practice explaining approach

**Goals:**
- Attempt both Medium problems
- Focus on understanding, not just solving
- Create mental template for Binary Search

---

#### Monday, Nov 3 (PLANNED)
**Time:** 1 hour  
**Focus:** Binary Search + Review

**Target:**
- [ ] 1-2 more Binary Search problems (Easy/Medium mix)
- [ ] Quick review of weekend problems
- [ ] Start thinking about next pattern (Trees or Linked Lists)

**Suggested Problems:**
- #74 - Search a 2D Matrix (Medium)
- #367 - Valid Perfect Square (Easy)

---

#### Tuesday, Nov 4 (PLANNED)
**Time:** 1 hour  
**Focus:** Finish Binary Search mastery

**Target:**
- [ ] 1-2 final Binary Search problems
- [ ] Reach 8-10 total Binary Search problems
- [ ] Consolidation: can explain template and variations

**Suggested Problems:**
- #441 - Arranging Coins (Easy)
- #875 - Koko Eating Bananas (Medium)

---

#### Wednesday, Nov 5 (PLANNED)
**Time:** 1 hour  
**Focus:** Binary Search wrap-up or START TREES 🌲

**Option A: If Binary Search feels solid**
- [ ] Start Trees pattern
- [ ] First tree problem: #104 - Maximum Depth of Binary Tree (Easy)
- [ ] Read: Tree traversal basics (DFS/BFS)

**Option B: If need more Binary Search**
- [ ] 1-2 more Binary Search problems
- [ ] Focus on weaker variations

---

#### Thursday, Nov 6 (PLANNED)
**Time:** 1 hour  
**Focus:** Trees or Binary Search final problems

**Target:**
- [ ] If started Trees: continue with 1-2 more tree problems
- [ ] If Binary Search: wrap up pattern mastery
- [ ] Weekly review and planning

---

### Week 1 Success Criteria

**Must Complete:**
- ✅ 8-10 Binary Search problems total
- ✅ At least 2 Medium problems attempted
- ✅ 6 out of 7 practice days
- ✅ All solutions documented

**Stretch Goals:**
- 🎯 Start Trees by Wed/Thu
- 🎯 <15 min avg on Binary Search Easy
- 🎯 <30 min on Binary Search Medium
- 🎯 Perfect 7/7 practice days

---

## Week 2 Preview: Nov 7 - Nov 13, 2025

### Tentative Plan

**Primary Focus:** Trees (DFS/BFS fundamentals)  
**Secondary:** Continue mixed Binary Search practice

**Target:**
- 10-12 Tree problems (mix Easy/Medium)
- Patterns: Tree traversal, DFS, BFS, level-order
- Goal: Comfortable with tree recursion

**Key Problems to Cover:**
- Tree traversal (preorder, inorder, postorder)
- Maximum/Minimum depth
- Symmetric tree
- Path sum problems
- Level order traversal (BFS)

---

## Week 3-4 Preview: Nov 14 - Nov 27, 2025

**Focus:** Trees (deep dive) + Linked Lists

**Targets:**
- Complete 20+ tree problems total
- Start Linked Lists (Fast/Slow pointer)
- First Medium/Hard tree problems

---

## Monthly Goals (November 2025)

**Month 1 Objectives:**
- [ ] Master Binary Search (8-10 problems) ✅ Week 1
- [ ] Master Trees basics (20-25 problems) - Weeks 2-4
- [ ] Start Linked Lists (8-10 problems) - Week 4
- [ ] Total: ~40-45 new problems in November
- [ ] Maintain 6-7 problems/week pace
- [ ] Build 7+ day streak

**Cumulative by End of November:**
- Current: 29 problems
- Target: 70-75 problems
- Patterns mastered: Binary Search, Trees (basic)

---

## Phase 1 Roadmap (Months 1-3)

### Month 1: November 2025
- **Weeks 1-2:** Binary Search
- **Weeks 3-4:** Trees fundamentals

### Month 2: December 2025
- **Weeks 5-6:** Trees (advanced) + Graphs (intro)
- **Weeks 7-8:** Linked Lists + Stacks/Queues

### Month 3: January 2026
- **Weeks 9-10:** Recursion & Backtracking
- **Weeks 11-12:** Dynamic Programming (intro)

**Target by End of Phase 1:** 120-140 problems

---

## Adjustment Protocol

**If ahead of schedule:**
- Increase difficulty (more Medium problems)
- Explore advanced variations
- Start next pattern early

**If behind schedule:**
- Focus on quality over quantity
- Stick to fundamentals
- Extend pattern by 2-3 days
- Do NOT skip patterns

**If consistency breaks (miss 2+ days):**
- Emergency protocol: 10-min review session
- Restart with easiest problem in current pattern
- Reassess weekly goals
- Address underlying issues

---

## Resources for Week 1

**Binary Search:**
- NeetCode: Binary Search section
- LeetCode: Binary Search topic tag
- Template to memorize:
```java
int left = 0, right = nums.length - 1;
while (left <= right) {
    int mid = (left + right) / 2;
    if (nums[mid] < target) left = mid + 1;
    else if (nums[mid] > target) right = mid - 1;
    else return mid;
}
return left; // or -1, depending on problem
```

**Upcoming (Trees):**
- Review: Tree traversal types
- Recursion fundamentals
- DFS vs BFS

---

## Weekly Check-In Questions

**Answer these at end of each week:**

1. How many problems did I solve this week?
2. How many days did I practice?
3. What pattern(s) did I work on?
4. What was my biggest challenge?
5. What did I learn that will help in interviews?
6. Am I on track for my weekly goal?
7. What needs to change for next week?

---

**Last Updated:** October 31, 2025  
**Next Review:** November 6, 2025 (end of Week 1)

