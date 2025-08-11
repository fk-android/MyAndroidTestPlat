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

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.myandroidtestplat.R
import com.example.myandroidtestplat.databinding.ActivityDetailsBinding
import com.example.myandroidtestplat.ui.shareelements.data.Item

class DetailsActivity : AppCompatActivity() {

  private var item: Item? = null
  private var _binding:ActivityDetailsBinding?=null
  private val binding get() = _binding!!

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    _binding=ActivityDetailsBinding.inflate(layoutInflater)
    setContentView(binding.root)

    item = intent.getParcelableExtra(getString(R.string.bundle_extra_item))

    supportFragmentManager
        .beginTransaction()
        .setReorderingAllowed(true)
        .replace(binding.detailsFragmentContainer.id,
            DetailsFragment(),
            DetailsFragment::class.java.simpleName)
        .commit()
  }

  // Supports reverse shared-element transition on ActionBar Up / Home
  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      android.R.id.home -> {
        supportFinishAfterTransition()
        return true
      }
    }
    return super.onOptionsItemSelected(item)
  }

  /**
   * Handles click on Share FAB, shares Title and Price of an item
   */
  fun onClickShareFab(view: View) {
    val shareText = item?.title + " for sell @ " + item?.price.toString() + getString(R.string.currency_symbol)
    val shareIntent = Intent(Intent.ACTION_SEND)
    shareIntent.type = "text/plain"
    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
    startActivity(shareIntent)
  }

}
