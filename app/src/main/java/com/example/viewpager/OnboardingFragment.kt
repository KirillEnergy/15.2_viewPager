package com.example.viewpager

import android.os.Bundle
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_onboarding.*

class OnboardingFragment:Fragment(R.layout.fragment_onboarding) //для фрагмента устанавливаем разметку
{
	//установим значение из аргументов во фрагмент после создания view. Метод жц onActivityCreated

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		requireView().setBackgroundResource(requireArguments().getInt(KEY_COLOR))
		textView.setText(requireArguments().getInt(KEY_TEXT))
		imageView.setImageResource(requireArguments().getInt(KEY_IMAGE))
	}

	companion object
	{
		private const val KEY_TEXT = "text"
		private const val KEY_COLOR = "color"
		private const val KEY_IMAGE = "image"

		//создаем фабричную функцию, которая создает фрагмент с аргументами
		fun	newInstance(
			@StringRes textRes: Int,
			@ColorRes bgColorRes: Int,
			@DrawableRes drawableRes: Int
		): OnboardingFragment{
			//extension функция
			return OnboardingFragment.withArguments{
				putInt(KEY_TEXT, textRes)
				putInt(KEY_COLOR, bgColorRes)
				putInt(KEY_IMAGE, drawableRes)
			}
		}
	}
}

