/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.myandroidtestplat.ui.shareelements.ui.details

import android.os.Bundle
import android.transition.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myandroidtestplat.R
import com.example.myandroidtestplat.databinding.FragmentDetailsBinding
import com.example.myandroidtestplat.ui.shareelements.data.Item

class DetailsFragment : Fragment() {

  private var item: Item? = null

    private var _binding:FragmentDetailsBinding?=null
    private val binding get() = _binding!!
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View {
      _binding=FragmentDetailsBinding.inflate(inflater,container,false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    item = activity?.intent?.getParcelableExtra(getString(R.string.bundle_extra_item))
    item?.let {
      populateDetails(item)

      // Transition animation lifecycle
      activity?.window?.sharedElementEnterTransition?.addListener(
          object : Transition.TransitionListener {

            override fun onTransitionStart(transition: Transition) {}

            override fun onTransitionEnd(transition: Transition) {
              binding.shareFab?.let {
                if (!binding.shareFab.isShown) {
                  binding.shareFab.show()
                }
              }
            }

            override fun onTransitionCancel(transition: Transition) {}

            override fun onTransitionPause(transition: Transition) {}

            override fun onTransitionResume(transition: Transition) {}
          })

      // Defining transition dynamically
      binding.itemImageView.setOnClickListener {
        val changeImageAnimation = ChangeImageTransform()

        // Set animation as shared-element transition
        val galleryFragment = GalleryFragment()
        galleryFragment.sharedElementEnterTransition = changeImageAnimation
        galleryFragment.sharedElementReturnTransition = changeImageAnimation

        // Show GalleryFragment with transition animation
        requireFragmentManager()
            .beginTransaction()
            .setReorderingAllowed(true)
            .addSharedElement(binding.itemImageView, binding.itemImageView.transitionName)
            .replace((view.parent as ViewGroup).id,
                galleryFragment,
                GalleryFragment::class.java.simpleName)
            .addToBackStack(null)
            .commit()
      }
    }
  }

  /**
   * Binds item details with views
   */
  private fun populateDetails(item: Item?) {
    (activity as AppCompatActivity).supportActionBar?.title = item?.category?.name
    binding.itemImageView.setImageResource(item?.imageId!!)
    binding.includContent.priceTextView.text = getString(R.string.currency_symbol) + item.price.toString()
      binding.includContent.titleTextView.text = item.title
      binding.includContent.detailsTextView.text = item.details
  }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}
