(list
 (channel
  (name 'guix)
  (url "https://git.savannah.gnu.org/git/guix.git")
  (branch "master")
  (commit
   "20303c0b1c75bc4770cdfa8b8c6b33fd6e77c168")
  (introduction
   (make-channel-introduction
    "9edb3f66fd807b096b48283debdcddccfea34bad"
    (openpgp-fingerprint
     "BBB0 2DDF 2CEA F6A8 0D1D  E643 A2A0 6DF2 A33A 54FA"))))

 (channel
  (name 'personal)
  (url "https://git.sr.ht/~krevedkokun/guix-channel")
  (branch "master")
  (commit
   "cdb9c3d54d2a9d70ad499c0350e6173fb2707cb7")
  (introduction
   (make-channel-introduction
    "8adfc051b27c8add369345bcf44299ff8fc16fb2"
    (openpgp-fingerprint
     "9946 5567 F17F F3EF D363  0034 8469 C699 F664 6AC6"))))

 (channel
  (name 'nonguix)
  (url "https://gitlab.com/nonguix/nonguix")
  (branch "master")
  (commit
   "1ed9725c2546147467ffda02379d72a13a5f3f06")
  (introduction
   (make-channel-introduction
    "897c1a470da759236cc11798f4e0a5f7d4d59fbc"
    (openpgp-fingerprint
     "2A39 3FFF 68F4 EF7A 3D29  12AF 6F51 20A0 22FB B2D5")))))
